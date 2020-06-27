package br.com.codenation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codenation.model.interfaces.IModel;
import lombok.AllArgsConstructor;

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

    public List<MODEL> findAll(Sort sort){
        return repository.findAll(sort);
    }

    public List<MODEL> findAllById(Iterable<ID> ids){
        return repository.findAllById(ids);
    }

    public List<MODEL> saveAll(Iterable<MODEL> models){
        return repository.saveAll(models);
    }

    public void flush(){
        repository.flush();
    }

    public MODEL saveAndFlush(MODEL model){
        return repository.saveAndFlush(model);
    }

    public void deleteInBatch(Iterable<MODEL> models){
        repository.deleteInBatch(models);
    }

    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }


}
