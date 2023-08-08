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
	
	@Test
	public void deveRetornarNumeroInteiroNaDivisao() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(6, 2);
		
		Assertions.assertEquals(3, resultado);
	}
	
	@Test
	public void deveRetornarNumeroNegativoNaDivisao() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(6, -2);
		
		Assertions.assertEquals(-3, resultado);
	}
	
	@Test
	public void deveRetornarNumeroDecimalNaDivisao() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(10, 3);
		
		Assertions.assertEquals(3.33, resultado, 0.01);
	}
	
	@Test
	public void deveRetornarZeroComNumeradorZeroNaDivisao() {
		Calculadora calc = new Calculadora();
		float resultado = calc.dividir(0, 3);
		
		Assertions.assertEquals(0, resultado);
	}
	
	@Test
	public void deveLancarExcecaoQuandoDividirPorZero_Junit4() {
		try {
			float resultado = 10/0;
			Assertions.fail("deveria ter sido lancado uma exceção na divisao");
		} catch (ArithmeticException e) {
			Assertions.assertEquals("/ by zero", e.getMessage());
		}
	}
	
	@Test
	public void deveLancarExcecaoQuandoDividirPorZero_Junit5() {
		ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> {			
			float resultado = 10/0;
		});
		
		Assertions.assertEquals("/ by zero", exception.getMessage());
	}
	
}
