package com.book.bookservice.controller;

import com.book.bookservice.exception.NoSuchBookException;
import com.book.bookservice.model.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({NoSuchBookException.class})
    public Response handleNoSuchBookException(Exception exception) {
        return Response.createResponseWithErrors(List.of(exception.getMessage()));
    }

}
