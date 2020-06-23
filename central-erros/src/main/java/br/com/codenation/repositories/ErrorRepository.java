package br.com.codenation.repositories;

import br.com.codenation.model.Error;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ErrorRepository extends JpaRepository<Error, UUID>, JpaSpecificationExecutor<Error> {
}
