package com.test.movie.infrastructure.api.moviedb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EditResponse {
    private int id;
    @JsonProperty("status_message")
    private String apiMessage;

    private boolean success;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(String apiMessage) {
        this.apiMessage = apiMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
