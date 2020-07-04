package br.com.codenation.main.controllers;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

import java.util.Random;
import java.util.UUID;

import br.com.codenation.model.User;
import br.com.codenation.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired private UserService userService;

    @Test
    @Transactional
    public void shouldFetchAllUsers() throws Exception{
        User user1 = createUser("Joao Arnaldo de Freitas", "jão@joao.com.br-joao", "jarnaldo@teste.com", true);

        User user2 = createUser("Harry Potter", "sapoChocolate", "reuri@poti.com", true);

        ResultActions perform = mvc.perform(get("/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

        perform.andExpect(jsonPath("$[0].id", is(user1.getId().toString())));
        perform.andExpect(jsonPath("$[0].name", is(user1.getName())));
        perform.andExpect(jsonPath("$[0].password", is(user1.getPassword())));
        perform.andExpect(jsonPath("$[0].token", is(user1.getToken())));
        perform.andExpect(jsonPath("$[0].email", is(user1.getEmail())));
        perform.andExpect(jsonPath("$[0].active", is(user1.getActive())));
    }

    @Test
    @Transactional
    public void shouldNotReturnAnyUsers() throws Exception{
        mvc.perform(get("/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    @Transactional
    public void shouldFetchOneUserById() throws Exception{
        User user = createUser("Gisele Almeida Pereira", "gisele.com.br-pereira", "giselep@teste.com", true);

        ResultActions perform = mvc.perform(get("/user/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").doesNotExist());

    }

    @Test
    @Transactional
    public void shouldNotReturnAnyUserBecauseOfInvalidId() throws Exception {
        User user = createUser("Felipe Carneiro", "com.br-felipe", "felipec@teste.com", true);

        ResultActions perform = mvc.perform(get("/user/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").doesNotExist());
    }

//    @Test
//    @Transactional
//    public void shouldDeleteAnUser() throws Exception {
//        User user = createUser("Jane Oliveira da Silva", "jane-oliveiraS", "jane.silva@teste.com", true);
//
//        userService.delete(user.getId());
//        ResultActions perform = mvc.perform(get("/user/" + user.getId().toString())
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(0)));
//
//  }

    private User createUser(String name, String password, String email, Boolean active){
        Random rand = new Random();
        User user = User.builder()
                .id(UUID.randomUUID())
                .name(name)
                .password(password)
                .token(String.valueOf((rand.nextInt())))
                .email(email)
                .active(active)
                .build();

        return userService.save(user);
    }
}
