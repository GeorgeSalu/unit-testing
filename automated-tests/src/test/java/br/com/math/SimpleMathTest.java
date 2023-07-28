package br.com.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {
	
	SimpleMath math;

	
	@BeforeAll
	static void setup() {
		System.out.println("Running @Beforeall");
	}
	
	@AfterAll
	static void cleanup() {
		System.out.println("Running @Afterall");
	}
	
	@BeforeEach
	void beforeEachMethod() {
		math = new SimpleMath();
	}
	
	@AfterEach
	void afterEachMethod() {
		System.out.println("Running @AfterEach");
	}

	// test[System Under Test]_[Condition or State Chane][Expected Result]
	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
	void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
		// AAA Arrange, Act, Assert
		// given / Arrange
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		double expected = 8.2D;
		
		// when / Act
		Double actual = math.sum(firstNumber, secondNumber);

		// Then / Assert
		assertEquals(expected, actual, () -> "6.2+2 did not produce 8.2");
	}
	
	@Test
	@DisplayName("Test 6.2 - 2 = 4.2")
	void testSubtraction() {
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.subtraction(firstNumber, secondNumber);
		double expected = 4.2D;
		
		assertEquals(expected, actual, () -> "6.2-2 did not produce 8.2");
	}
	
	@Test
	@DisplayName("Test 6.2 * 2 = 12.4")
	void testMultiplication() {
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.multiplication(firstNumber, secondNumber);
		double expected = 12.4D;
		
		assertEquals(expected, actual, () -> "6.2*2 did not produce 8.2");
	}
	
	@Test
	@DisplayName("Test 6.2 / 2 = 3.1")
	void testDivision() {
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.division(firstNumber, secondNumber);
		double expected = 3.1D;
		
		assertEquals(expected, actual, () -> "6.2/2 did not produce 8.2");
	}
	
	// test[System Under Test]_[Condition or State Chane]_[Expected Result]
	//@Disabled("TODO: We need still work on it")
	@Test
	@DisplayName("Test Division By Zero")
	void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
		// given
		double firstNumber = 6.2D;
		double secondNumber = 0D;
		
		var expectedMessage = "impossible to divide by zero";
		
		// when & then 
		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
			math.division(firstNumber, secondNumber);
		});
		assertEquals(expectedMessage, actual.getMessage());
	}
	
	@Test
	@DisplayName("Test (6.2 + 2)/2 = 4.1")
	void testMean() {
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.mean(firstNumber, secondNumber);
		double expected = 4.1D;
		
		assertEquals(expected, actual, () -> "(6.2+2)/2 did not produce 8.2");
	}
	
	@Test
	@DisplayName("Test Square root of 81 = 9")
	void testSquareRoot() {
		double number = 81D;
		double expected = 9D;
		
		Double actual = math.squaredRoot(number);
		
		assertEquals(expected, actual, () -> "square root of 81 did not produce 8.2");
	}
	
}
