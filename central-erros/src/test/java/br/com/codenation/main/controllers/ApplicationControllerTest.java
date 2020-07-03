package br.com.codenation.main.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Random;
import java.util.UUID;

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

import br.com.codenation.model.Application;
import br.com.codenation.service.ApplicationService;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class ApplicationControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ApplicationService applicationservice;
	
	@Test
	@Transactional
	public void deveRetornarTodasAsApplications() throws Exception {
		Application application1 = criarApplication("127.0.0.1");
		
		Application application2 = criarApplication("google.com");
		
		
			ResultActions perform = mvc.perform(get("/application")
					.contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$", hasSize(2)));
			
			perform.andExpect(jsonPath("$[0].id", is(application1.getId().toString())));
			perform.andExpect(jsonPath("$[0].name", is(application1.getName())));
			perform.andExpect(jsonPath("$[0].token", is(application1.getToken())));
			
			perform.andExpect(jsonPath("$[1].id", is(application2.getId().toString())));
			perform.andExpect(jsonPath("$[1].name", is(application2.getName())));
			perform.andExpect(jsonPath("$[1].token", is(application2.getToken())));
	}
	
	@Test 
	@Transactional 
	public void naoRetornarNenhumaApplication() throws Exception {
		mvc.perform(get("/application")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(0)));
	}
	
	@Test
	@Transactional
	public void deveRetornarUmaApplicationComIdIgual() throws Exception {
		Application application = criarApplication("127.0.0.1");
		
		ResultActions perform = mvc.perform(get("/application/"+application.getId().toString())
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
		
		perform.andExpect(jsonPath("$.id", is(application.getId().toString())));
		perform.andExpect(jsonPath("$.name", is(application.getName())));
		perform.andExpect(jsonPath("$.token", is(application.getToken())));
		
	}
	
	private Application criarApplication(String name) {
		Random rand = new Random();
		Application application = Application.builder()
				.name(name)
				.id(UUID.randomUUID())
				.token(String.valueOf(rand.nextInt()))
				.build();
		return applicationservice.save(application);
	}
 }
