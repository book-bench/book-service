package com.book.bookservice.controller;

import com.book.bookservice.exception.NoSuchBookException;
import com.book.bookservice.model.Response;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ControllerAdvice
public class ExceptionController {

    @Value("${log-messages.rejected-request-log}")
    private String RejectedRequestLogMessage;

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler({NoSuchBookException.class})
    public Response handleNoSuchBookException(Exception exception) {
        return Response.createResponseWithErrors(List.of(exception.getMessage()));
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public Response handleConstrainViolationException(Exception exception) {
        logger.info(RejectedRequestLogMessage, exception.getMessage());
        return Response.createResponseWithErrors(List.of(exception.getMessage()));
    }

}
