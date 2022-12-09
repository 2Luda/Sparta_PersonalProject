package com.sparta.sparta_personalproject.Exception;

public class NotIDException extends Exception{
    public NotIDException() {
        super("아이디가 올바르지 않습니다.");
    }
    public NotIDException(String msg) {super(msg);}
}
