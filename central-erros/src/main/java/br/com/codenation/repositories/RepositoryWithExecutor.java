package br.com.codenation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RepositoryWithExecutor<MODEL, ID> extends JpaRepository<MODEL, ID>, JpaSpecificationExecutor<MODEL> {
}
