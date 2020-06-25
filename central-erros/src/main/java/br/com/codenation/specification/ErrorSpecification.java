package br.com.codenation.specification;

import br.com.codenation.model.Error;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import br.com.codenation.commons.EnvironmentEnum;
import br.com.codenation.commons.LevelEnum;

public class ErrorSpecification {

	public static Specification<Error> addFilters(EnvironmentEnum environment, String origin, LevelEnum level,
			String description, String orderBy) {
		return new Specification<Error>() {
			public Predicate toPredicate(Root<Error> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();

				if (!StringUtils.isEmpty(environment)) {
					predicates.add(cb.equal(root.get("environment"), environment));
				}

				if (!StringUtils.isEmpty(origin)) {
					predicates.add(cb.like(root.get("origin"), origin));
				} else if (!StringUtils.isEmpty(level)) {
					predicates.add(cb.equal(root.get("level"), level));
				} else if (!StringUtils.isEmpty(description)) {
					predicates.add(cb.equal(root.get("description"), description));
				}

				if (!StringUtils.isEmpty(orderBy)) {
					cb.desc(root.get(orderBy)); 
				}
				
				return cb.and(predicates.toArray(new Predicate[] {}));
			}
		};
	}
}
