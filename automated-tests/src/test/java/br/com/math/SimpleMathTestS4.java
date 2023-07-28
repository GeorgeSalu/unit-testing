package br.com.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTestS4 {
	
	SimpleMath math;

	@BeforeEach
	void beforeEachMethod() {
		math = new SimpleMath();
	}
	
	@DisplayName("Test 6.2 / 2 = 3.1")
	@ParameterizedTest
	@CsvFileSource(resources = "/testDivision.csv")
	void testDivision(double firstNumber,double secondNumber, double expected ) {
		
		System.out.println("Test "+firstNumber+"/"+secondNumber+" = "+expected);
		Double actual = math.division(firstNumber, secondNumber);
		
		assertEquals(expected, actual,2D, () -> "6.2/2 did not produce 8.2");
	}
		
	
}
