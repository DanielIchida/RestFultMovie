package com.test.movie.infrastructure.api.moviedb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EditRequest {

    private String name;
    private String description;
    @JsonProperty("iso_639_1")
    private String iso;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
}
