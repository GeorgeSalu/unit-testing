package br.com.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class SimpleMathTest {

	@Test
	void testSum() {
		SimpleMath math = new SimpleMath();
		Double actual = math.sum(6.2D, 2D);
		double expected = 8.2D;
		
		assertEquals(expected, actual, "6.2+2 did not produce 8.2");
		assertNotEquals(9.2, actual);
		assertNotNull(actual);
	}

}
