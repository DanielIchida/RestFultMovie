package com.test.movie.infrastructure.restful.controllers;

import com.test.movie.infrastructure.restful.dto.response.ResponseDtoError;
import com.test.movie.infrastructure.restful.dto.response.ResponseDtoOk;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {
    public ResponseEntity errorMessage(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDtoError().message(e.getMessage()));
    }

    public ResponseEntity oKMessage(Object data) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDtoOk().message(data));
    }
}
