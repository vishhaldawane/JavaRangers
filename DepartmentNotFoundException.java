package com.company;

public class DepartmentNotFoundException extends  RuntimeException {
    public DepartmentNotFoundException(String msg) {
        super(msg);
    }
}
