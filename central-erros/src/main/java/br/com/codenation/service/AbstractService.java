package br.com.codenation.service;

import br.com.codenation.model.interfaces.IModel;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public abstract class AbstractService<MODEL extends IModel, ID> {

    private final JpaRepository<MODEL, ID> repository;

    public MODEL save(MODEL model){
        return repository.save(model);
    }

    public List<MODEL> saveAll(List<MODEL> models){
        return repository.saveAll(models);
    }

    public MODEL update(MODEL model) {
        return repository.save(model);
    }

    public MODEL findById(ID id) {
        Optional<MODEL> model = repository.findById(id);
        if(model.isPresent()){
            return model.get();
        }
        return null;
    }

    public List<MODEL> findAll(){
        return repository.findAll();
    }

    public void delete(ID id){
        repository.deleteById(id);

    }
}
