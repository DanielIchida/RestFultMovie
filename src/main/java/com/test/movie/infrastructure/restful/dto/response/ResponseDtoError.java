package com.test.movie.infrastructure.restful.dto.response;

public class ResponseDtoError extends ResponseDto {
    public ResponseDto message(String error) {
        setError(error);
        setMessage("ERROR");
        setResult(null);
        return this;
    }

}
