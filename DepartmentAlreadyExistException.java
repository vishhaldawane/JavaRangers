package com.company;

public class DepartmentAlreadyExistException extends  RuntimeException {
    public DepartmentAlreadyExistException(String msg) {
        super(msg);
    }
}