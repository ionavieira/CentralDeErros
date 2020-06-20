package br.com.codenation.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.codenation.model.interfaces.IModel;
import org.hibernate.annotations.GenericGenerator;

import br.com.codenation.commons.EnvironmentEnum;
import br.com.codenation.commons.LevelEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "error")
public class Error implements IModel {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String title;

    private String details;

    private Integer number;

    private String origin;

    private LevelEnum level;

    private Date date;

    private EnvironmentEnum environment;

    @ManyToOne
    private User user;
}
