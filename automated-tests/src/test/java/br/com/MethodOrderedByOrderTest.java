package br.com;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(3)
@TestMethodOrder(MethodOrderer.MethodName.class)
class MethodOrderedByOrderTest {

	@Test
	void testA() {
		System.out.println("Running Test A");
	}
	
	@Test
	void testB() {
		System.out.println("Running Test B");
	}
	
	@Test
	void testC() {
		System.out.println("Running Test C");
	}
	
	@Test
	void testD() {
		System.out.println("Running Test D");
	}

}
