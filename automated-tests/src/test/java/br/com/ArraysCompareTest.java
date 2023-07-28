package br.com;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArraysCompareTest {

	@Test
	void test() {
		int[] numbers = {25,8,21,32,3};
		int[] expectedArray = {3,8,21,25,32};
		
		Arrays.sort(numbers);
		
		assertArrayEquals(numbers, expectedArray);
	}
	
	@Test
	//@Timeout(1)
	//@Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
	void testSortPerformance() {
		int[] numbers = {25,8,21,32,3};
		
		for (int i = 0; i < 100000; i++) {
			numbers[0] = i;
			Arrays.sort(numbers);
			
		}
	}

}
