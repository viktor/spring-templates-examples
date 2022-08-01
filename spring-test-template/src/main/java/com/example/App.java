package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

@SpringBootApplication
public class App {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        List<Integer> nums = Arrays.asList(new Integer[]{ 1,2,3,4,5,6,7,8,9 });
        List<Integer> copy = Arrays.asList(new Integer[]{ 1,2,3,4,5,6,7,8,9 });
        List<String> unevens = new ArrayList<>();

        copy.remove(new Integer(1));
        for(Integer n: nums){
            copy.remove(n);
            if(copy.stream().filter(num -> num%n == 0 && num != n && num != 1).findAny().isPresent()){
                unevens.add(String.valueOf(n));
            }
        }

        System.out.println(unevens.toString());
    }
}
