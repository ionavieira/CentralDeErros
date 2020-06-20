package br.com.codenation.model.interfaces;

import java.util.UUID;

public interface IModel<ID> {
    ID getId();
    void setId(ID id);
}
