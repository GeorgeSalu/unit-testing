package br.com.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

class DemoRepeatedTest {
	
	SimpleMath math;
	
	@BeforeEach
	void beforeEachMethod() {
		math = new SimpleMath();
	}

	
	@RepeatedTest(value = 3, name = "{displayName}. Repetition {currentRepetition} of {totalRepetitions}!")
	@DisplayName("Test Division By Zero")
	void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException(RepetitionInfo repetitionInfo) {
		
		System.out.println("Repetition n "+repetitionInfo.getCurrentRepetition()+" of "+repetitionInfo.getTotalRepetitions());
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

}
