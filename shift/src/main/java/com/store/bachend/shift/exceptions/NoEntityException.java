package com.store.bachend.shift.exceptions;

public class NoEntityException extends Exception{

    private Long id;

    public NoEntityException(Long id) {
        this.id = id;
    }

    public String toString() {
        return "Product with id = " + id + " NOT FOUND!";
    }
}
