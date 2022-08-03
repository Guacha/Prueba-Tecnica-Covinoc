package com.guacha.prueba.models;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Guacha (Julian Espitaleta)
 *
 */
public class User {

    private final Long id;

    private final String name;
    private final Long telephone;

    public User(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("tel") Long telephone) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getTelephone() {
        return telephone;
    }
}
