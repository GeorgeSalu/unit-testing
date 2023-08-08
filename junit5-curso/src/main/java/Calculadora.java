
public class Calculadora {

	public int soma(int a,int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		System.out.println(calculadora.soma(2, 3) == 5);
		System.out.println(calculadora.soma(3, 3) == 7);
		System.out.println(calculadora.soma(5, 6) == 11);
	}
	
}
