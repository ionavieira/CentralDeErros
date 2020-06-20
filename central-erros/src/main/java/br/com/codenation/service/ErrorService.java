package br.com.codenation.service;

import br.com.codenation.model.Error;
import br.com.codenation.repositories.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ErrorService extends AbstractService<Error, UUID> {

    private ErrorRepository errorRepository;

    @Autowired
    public ErrorService(ErrorRepository errorRepository){
        super(errorRepository);
        this.errorRepository = errorRepository;
    }
}
