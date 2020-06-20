package br.com.codenation.controllers;

import br.com.codenation.model.User;
import br.com.codenation.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Api(value = "Responsável pelo controle de usuários da aplicação.")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Registra um novo usuário")
    public User create(@RequestBody User user){
        return userService.save(user);
    }

}
