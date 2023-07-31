package br.com.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListWithBDDTest {

	@Test
	void testMockList_When_SizeIsCalled_ShouldReturn10() {
		// Given / Arrange
		List<?> list = mock(List.class);
		given(list.size()).willReturn(10);
		// When / Act
		// Then / Assert
		assertThat( list.size(), is(10));
	}
	
	@Test
	void testMockList_When_SizeIsCalled_ShouldReturnMultipleValues() {
		// Given / Arrange
		List<?> list = mock(List.class);
		given(list.size()).willReturn(10).willReturn(20);
		// When / Act
		// Then / Assert
		assertThat(list.size(), is(10));
		assertThat(list.size(), is(20));
		assertThat(list.size(), is(20));
	}
	
	@Test
	void testMockList_When_GetIsCalled_ShouldReturnJava() {
		// Given / Arrange
		var list = mock(List.class);
		given(list.get(0)).willReturn("Java");
		// When / Act
		// Then / Assert
		assertThat(list.get(0), is("Java"));
	}
	
	@Test
	void testMockList_When_GetIsCalledWithArgumentMatcher_ShouldReturnJava() {
		// Given / Arrange
		var list = mock(List.class);
		given(list.get(anyInt())).willReturn("Java");
		// When / Act
		// Then / Assert
		assertThat(list.get(anyInt()), is("Java"));
	}
	
	@Test
	void testMockList_When_ThrowsAnException() {
		// Given / Arrange
		var list = mock(List.class);
		given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar"));
		// When / Act
		// Then / Assert
		assertThrows(RuntimeException.class, 
				() -> {
					list.get(anyInt());},
				() -> "should have throw an RuntimeException");
	}
}
