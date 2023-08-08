import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	
	@Test
	public void somar() {
		Calculadora calculadora = new Calculadora();
		Assertions.assertTrue(calculadora.soma(2, 7) == 9);
		Assertions.assertEquals(5, calculadora.soma(2, 3));
	}
}
