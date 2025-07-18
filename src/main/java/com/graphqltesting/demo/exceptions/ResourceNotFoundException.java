package com.graphqltesting.demo.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String entity, Long id){
        super(entity + " not found with id " + id);
    }



}
