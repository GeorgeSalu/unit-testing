package br.com.mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class HamcrestMatchersTest {

	@Test
	void testHamcrestMatchers() {
		// given
		List<Integer> scores = Arrays.asList(99, 100, 101, 105);
		
		// when / then
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(100,101));
	}

}
