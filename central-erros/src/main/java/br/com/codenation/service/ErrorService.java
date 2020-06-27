package br.com.codenation.service;

import br.com.codenation.model.Error;
import br.com.codenation.repositories.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import static br.com.codenation.specification.ErrorSpecification.addFilters;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ErrorService extends AbstractService<Error, UUID> {

    private ErrorRepository errorRepository;

    @Autowired
    public ErrorService(ErrorRepository errorRepository){
        super(errorRepository);
        this.errorRepository = errorRepository;
    }

    public List<Error> findWithFilters(Map<Class<?>, Class<?>> params, Pageable pageable) {
    	Page<Error> pageData = errorRepository.findAll(addFilters(params), pageable);
    	return pageData.getContent();
    }
}
