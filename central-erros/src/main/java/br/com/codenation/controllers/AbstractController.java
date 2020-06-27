package br.com.codenation.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.codenation.model.interfaces.IModel;
import br.com.codenation.service.AbstractService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public abstract class AbstractController<MODEL extends IModel, ID> {

    private AbstractService<MODEL, ID> service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Lista todas os models")
    public List<MODEL> listAll() {
        return service.findAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca um registro no banco pelo id")
    public MODEL getById(@PathVariable ID id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adiciona um novo registro no banco")
    public MODEL create(@RequestBody MODEL model){
        return service.save(model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deleta um registro no banco pelo id")
    public void delete(@PathVariable ID id){
         service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Atualiza um registro no banco pelo id")
    public MODEL  update(@PathVariable ID id, @RequestBody MODEL model){
        model.setId(id);
        return service.update(model);
    }

}
