package br.com.codenation.controllers;

import br.com.codenation.model.Error;
import br.com.codenation.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/error")
public class ErrorController extends AbstractController<Error, UUID>{

    private ErrorService errorService;

    @Autowired
    public ErrorController(ErrorService errorService){
        super(errorService);
        this.errorService = errorService;
    }

}
