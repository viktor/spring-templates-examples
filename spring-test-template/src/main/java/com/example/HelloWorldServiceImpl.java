package com.example;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public void message(String msg) throws NullPointerException {
        if(msg == null)
            throw new NullPointerException("Message can't be null");

        System.out.println(msg);
    }
}
