package br.com.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {

	@Test
	void testMockList_When_SizeIsCalled_ShouldReturn10() {
		// Given / Arrange
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10);
		// When / Act
		// Then / Assert
		assertEquals(10, list.size());
	}
	
	@Test
	void testMockList_When_SizeIsCalled_ShouldReturnMultipleValues() {
		// Given / Arrange
		List<?> list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		// When / Act
		// Then / Assert
		assertEquals(10, list.size());
		assertEquals(20, list.size());
		assertEquals(20, list.size());
	}
	
	@Test
	void testMockList_When_GetIsCalled_ShouldReturnJava() {
		// Given / Arrange
		var list = mock(List.class);
		when(list.get(0)).thenReturn("Java");
		// When / Act
		// Then / Assert
		assertEquals("Java", list.get(0));
	}
	
	@Test
	void testMockList_When_GetIsCalledWithArgumentMatcher_ShouldReturnJava() {
		// Given / Arrange
		var list = mock(List.class);
		when(list.get(anyInt())).thenReturn("Java");
		// When / Act
		// Then / Assert
		assertEquals("Java", list.get(anyInt()));
	}
}
