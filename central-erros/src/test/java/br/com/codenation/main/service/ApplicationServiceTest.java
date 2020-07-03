package br.com.codenation.main.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.codenation.model.Application;
import br.com.codenation.repositories.ApplicationRepository;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@SpringBootTest
public class ApplicationServiceTest {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Test 
	@Transactional
	public void quandoBuscarTodos() {
		Application application1 = criarApplication("127.0.0.1");
				
		Application application2 = criarApplication("189.29.10.2");
		
		List<Application> result = applicationRepository.findAll();
		
		assertThat(result, hasSize(2));
	}
	
	@Test 
	@Transactional
	public void quandoBuscarPorIdQueExiste() {
		Application application = criarApplication("127.0.0.1");
		
		Optional<Application> result = applicationRepository.findById(application.getId());
		
		assertThat(result.isPresent(), is(Boolean.TRUE));
		assertThat(result.get().getName(), equalTo("127.0.0.1"));
	}
	
	private Application criarApplication(String name) {
		Random rand = new Random();
		Application application = Application.builder()
				.name(name)
				.id(UUID.randomUUID())
				.token(String.valueOf(rand.nextInt()))
				.build();
		return applicationRepository.save(application);
	}
}
