package com.test.movie.infrastructure.restful.dto.response;

public class ResponseDtoOk extends ResponseDto {
    public ResponseDto message(Object result) {
        setError("");
        setMessage("OK");
        setResult(result);
        return this;
    }

}
