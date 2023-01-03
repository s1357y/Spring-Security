package org.example.exceptions;

public class UserRegisterPasswordNotEqual extends RuntimeException{

    public UserRegisterPasswordNotEqual(String message){
        super(message);
    }

    public UserRegisterPasswordNotEqual(){
        super("비밀번호가 같지 않습니다. 다시 확인해주세요.");
    }
}
