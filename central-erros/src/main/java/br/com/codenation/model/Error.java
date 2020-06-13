package br.com.codenation.model;

import br.com.codenation.commons.EnvironmentEnum;
import br.com.codenation.commons.LevelEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "error")
public class Error {

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
