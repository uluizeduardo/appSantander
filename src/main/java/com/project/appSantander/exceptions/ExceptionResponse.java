package com.project.appSantander.exceptions;

//Objeto de resposta
public class ExceptionResponse {

    private String message;

    //Construtor que executa o Set
    public ExceptionResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
