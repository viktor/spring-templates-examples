package com.example;

import java.util.List;

public interface HelloWorldService {

    /**
     * Prints a message.
     *
     * @param msg incoming numbers
     * @throws NullPointerException If any of the arguments is null.
     */
    void message(String msg) throws NullPointerException;

}
