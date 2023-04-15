package com.test.movie.infrastructure.restful.dto.response;

public class EditResponseDto {
    private int id;
    private String apiMessage;

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
}
