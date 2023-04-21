package ru.netology.daolayerhibernate.exception;

public class InvalidPersonId extends RuntimeException{
    public InvalidPersonId(String msg) {
        super(msg);
    }
}
