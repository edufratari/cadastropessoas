package br.com.zup.cadastropessoas.application.commands.handler;

public class PersonNotFoundException extends Exception{

    public PersonNotFoundException(String message){
        super(message);
    }

}