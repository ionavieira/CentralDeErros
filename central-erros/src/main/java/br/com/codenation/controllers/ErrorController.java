package br.com.codenation.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.codenation.model.Error;
import br.com.codenation.service.ErrorService;

@RestController
@RequestMapping("/error")
public class ErrorController extends AbstractController<Error, UUID>{

    private ErrorService errorService;

    @Autowired
    public ErrorController(ErrorService errorService){
        super(errorService);
        this.errorService = errorService;
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<Error> listFilters(@RequestParam(required = false) Map<Class<?>, Class<?>> params,
    		@RequestParam(
    				value = "page",
    				required = false,
    				defaultValue = "0") int page,
    		@RequestParam(
    				value = "size",
    				required = false,
    				defaultValue = "5") int size,
    		@RequestParam(value = "orderBy",
    				defaultValue = "id") String orderBy,
    		@RequestParam (
    				value = "direction",
    				defaultValue = "asc") String direction) {
    	PageRequest pageRequest = PageRequest.of(page, size, Direction.fromString(direction), orderBy);
    	return errorService.findWithFilters(params, pageRequest);
    }
}
