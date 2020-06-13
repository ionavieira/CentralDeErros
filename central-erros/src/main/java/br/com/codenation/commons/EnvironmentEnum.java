package br.com.codenation.commons;

import lombok.Data;

public enum EnvironmentEnum {
    DEVELOPMENT("DEV"),
    HOMOLOGATION("HOM"),
    PRODUCTION("PRD");

    private String description;

    EnvironmentEnum(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
