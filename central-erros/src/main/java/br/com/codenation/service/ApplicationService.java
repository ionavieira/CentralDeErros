package br.com.codenation.service;

import br.com.codenation.model.Application;
import br.com.codenation.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.codenation.specification.GenericSpecificationBuilder.filterRecords;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ApplicationService extends AbstractService<Application, UUID> {

    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        super(applicationRepository);
        this.applicationRepository = applicationRepository;
    }

    public List<Application> findWithFilters(Map<Class<?>, Class<?>> params) {
    	return applicationRepository.findAll(filterRecords(params));
    }
}
