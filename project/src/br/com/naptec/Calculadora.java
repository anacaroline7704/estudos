package br.com.naptec;

public class Calculadora {

	public void soma() {
		int v1 = 1;
		int v2 = 1;
		int resultadoSoma = v1 + v2;
		System.out.println("Resultado da soma(1+1):" + resultadoSoma);
	}

	public void subtrai() {
		int S1 = 70;
		int S2 = 10;
		int resultadoSubtracao = S1 - S2;
		System.out.println("Resultado da subtração(70-10):" + resultadoSubtracao);

	}

	public void divide() {
		int d1 = 10;
		int d2 = 2;
		int resultadoDivisao = d1 / d2;
		System.out.println("Resultado da divisão(10÷2):" + resultadoDivisao);
	}

	public void multiplica() {
		int m1 = 3;
		int m2 = 7;
		int resultadoDivisao = m1 * m2;
		System.out.println("Resultado da multiplicação(3x7):" + resultadoDivisao);
	}

	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
		calc.ajuste(20, 30);
		calc.soma();
		calc.subtrai();
		calc.divide();
		calc.multiplica();
	}

	public void ajuste(double mesada, double taxa) {
		double resultado = mesada + taxa;
		System.out.println("Este é o resultado:" + resultado);
	}
}
