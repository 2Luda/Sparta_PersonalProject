package com.sparta.sparta_personalproject.Exception;

public class NotPasswordException extends Exception{

    public NotPasswordException() {
        super("패스워드가 올바르지 않습니다.");
    }
    public NotPasswordException(String msg) {super(msg);}
}
