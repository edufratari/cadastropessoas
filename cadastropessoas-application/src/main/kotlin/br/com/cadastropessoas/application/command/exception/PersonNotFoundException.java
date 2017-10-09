package br.com.cadastropessoas.application.command.exception;

public class PersonNotFoundException extends Exception{

    public PersonNotFoundException(String message){
        super(message);
    }

}