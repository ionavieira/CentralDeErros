package br.com.codenation.controllers;

import br.com.codenation.model.User;
import br.com.codenation.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@Api(value = "Responsável pelo controle de usuários da aplicação.")
public class UserController extends AbstractController<User, UUID>{

    @Autowired
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        super(userService);
        this.userService = userService;
    }

}
