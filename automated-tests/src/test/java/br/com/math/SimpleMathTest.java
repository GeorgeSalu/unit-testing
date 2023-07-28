package br.com.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleMathTest {

	// test[System Under Test]_[Condition or State Chane][Expected Result]
	@Test
	void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.sum(firstNumber, secondNumber);
		double expected = 8.2D;
		
		assertEquals(expected, actual, () -> "6.2+2 did not produce 8.2");
	}
	
	@Test
	void testSubtraction() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.subtraction(firstNumber, secondNumber);
		double expected = 4.2D;
		
		assertEquals(expected, actual, () -> "6.2-2 did not produce 8.2");
	}
	
	@Test
	void testMultiplication() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.multiplication(firstNumber, secondNumber);
		double expected = 12.4D;
		
		assertEquals(expected, actual, () -> "6.2*2 did not produce 8.2");
	}
	
	@Test
	void testDivision() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.division(firstNumber, secondNumber);
		double expected = 3.1D;
		
		assertEquals(expected, actual, () -> "6.2/2 did not produce 8.2");
	}
	
	// test[System Under Test]_[Condition or State Chane]_[Expected Result]
	@Test
	void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
		fail();
	}
	
	@Test
	void testMean() {
		SimpleMath math = new SimpleMath();
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.mean(firstNumber, secondNumber);
		double expected = 4.1D;
		
		assertEquals(expected, actual, () -> "(6.2+2)/2 did not produce 8.2");
	}
	
	@Test
	void testSquareRoot() {
		SimpleMath math = new SimpleMath();
		double number = 81D;
		double expected = 9D;
		
		Double actual = math.squaredRoot(number);
		
		assertEquals(expected, actual, () -> "square root of 81 did not produce 8.2");
	}

}
