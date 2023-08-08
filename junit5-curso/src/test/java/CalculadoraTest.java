import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	
	@Test
	public void somar() {
		Calculadora calculadora = new Calculadora();
		Assertions.assertTrue(calculadora.soma(2, 7) == 9);
		Assertions.assertEquals(5, calculadora.soma(2, 3));
	}
	
	@Test
	public void assertivas() {
		Assertions.assertEquals("Casa", "Casa");
		Assertions.assertNotEquals("Casa", "casa");
		Assertions.assertTrue("Casa".equalsIgnoreCase("CASA"));
		Assertions.assertTrue("Casa".endsWith("sa"));
		Assertions.assertTrue("Casa".startsWith("Ca"));
		
		List<String> s1 = new ArrayList<>();
		List<String> s2 = new ArrayList<>();
		List<String> s3 = null;
		
		Assertions.assertEquals(s1, s2);
		Assertions.assertSame(s2, s2);
		Assertions.assertNull(s3);
		Assertions.assertNotNull(s1);
	}
	
}
