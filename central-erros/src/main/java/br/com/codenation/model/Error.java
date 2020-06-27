package br.com.codenation.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.com.codenation.commons.EnvironmentEnum;
import br.com.codenation.commons.LevelEnum;
import br.com.codenation.model.interfaces.IModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "log")
public class Error extends AbstractAuditingEntity implements IModel<UUID> {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;

	@NotNull
	private String title;

	@NotNull
	private String details;

	@NotNull
	@ManyToOne
	private Application application;

	@Builder.Default
	private Boolean archived = false;

	@ManyToOne
	private User user;

	@NotNull
	@Enumerated(EnumType.STRING)
	private LevelEnum level;

	@NotNull
	@Enumerated(EnumType.STRING)
	private EnvironmentEnum environment;

}
