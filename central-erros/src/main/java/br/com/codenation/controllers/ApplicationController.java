package br.com.codenation.controllers;

import br.com.codenation.model.Application;
import br.com.codenation.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/application")
public class ApplicationController extends AbstractController<Application, UUID> {

    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService service) {
        super(service);
        this.applicationService = service;
    }

}
