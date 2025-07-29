package com.example.demo;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetExampleTest {

    int count=0;

    @BeforeEach
    void setUp(){
        count=0;
        System.out.println("before each test "+count);
    }

    @AfterEach
    void tearDown(){
        System.out.println("after each test");
    }

    @Test
    void testCountInc(){
        count+=1;
        assertEquals(1,count);
    }
}
