package br.com.codenation.service;

import br.com.codenation.model.Application;
import br.com.codenation.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class ApplicationService extends AbstractService<Application, UUID> {

    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        super(applicationRepository);
        this.applicationRepository = applicationRepository;
    }

}
