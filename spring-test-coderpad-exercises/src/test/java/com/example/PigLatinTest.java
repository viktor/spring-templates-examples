package com.example;

import org.junit.Assert;
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
public class PigLatinTest {

    @Autowired PigLatin pigLatin;

    @BeforeClass
    public static void setUp() { }

    @Test
    public void test01Scenario(){
        System.out.println(pigLatin.pigLatinize("Hola Mundo"));
    }

    @Test
    public void test02Scenario(){
        String input = "My fave song is 99 luftballoons";
        String expected = "y-May ave-fay ong-say is-way 99 uftballoons-lay";
        String result = pigLatin.pigLatinizeTakeHome(input);
        System.out.println(result);
        Assert.assertEquals(expected.trim(), result.trim());
    }

    @Test
    public void test03Scenario(){
        String input = "is 99 luftballoons";
        String expected = "is-way 99 uftballoons-lay";
        String result = pigLatin.pigLatinizeTakeHome(input);
        System.out.println(result);
        Assert.assertEquals(expected.trim(), result.trim());
    }

    @Test
    public void test04Scenario(){
        String input = "I've been wondering - what is the answer?!?!? How will we know it's correct?";
        String expected = "I've-way een-bay ondering-way - at-whay is-way e-thay answer-way?!?!? ow-Hay ill-way e-way ow-knay it's-way orrect-cay?";
        String result = pigLatin.pigLatinizeTakeHome(input);
        System.out.println(result);
        Assert.assertEquals(expected.trim(), result.trim());
    }

}
