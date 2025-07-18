package com.graphqltesting.demo.exceptions;

import org.springframework.graphql.execution.ErrorType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;

@ControllerAdvice
public class GraphQLExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public GraphQLError handleNotFound(ResourceNotFoundException ex) {
        return GraphqlErrorBuilder.newError().message(ex.getMessage()).errorType(ErrorType.NOT_FOUND).build();
    }

}
