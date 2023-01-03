package org.example.exceptions;

public class AlreadyRegisteredUserException extends RuntimeException{

    public AlreadyRegisteredUserException(String message){
        super(message);
    }

    public AlreadyRegisteredUserException(){
        super("이미 존재하는 이메일입니다.");
    }
}
