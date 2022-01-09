package com.chanduJunit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathTest {

	@Test
	void minAndMaxTest() {
		int a=Math.min(4 , 9);
		int b=Math.max(29, 31);
		assertEquals(4,a);
		assertEquals(31,b);
	}

}
