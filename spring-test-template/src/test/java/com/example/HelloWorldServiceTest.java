package com.example;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HelloWorldServiceTest {

    @Autowired
    private HelloWorldService numberLowerOrEqualService;
    private static String message;

    @BeforeClass
    public static void setUp() {
        message = "Hello World!";
    }

    @Test(expected = NullPointerException.class)
    public void test1NullPointerException() {
        numberLowerOrEqualService.message(null);
    }

    @Test
    public void test002IllegalThresholdArgument() {
        numberLowerOrEqualService.message(message);
    }

}
