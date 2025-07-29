package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//
//@SpringBootTest

class EcommerspringApplicationTests {

	@Test
	void testAddition() {
		int result=2+3;
		assertEquals(5,result);
		assertNotEquals(6,result);
	}




}
