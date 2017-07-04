package process;

import java.util.Random;

import org.junit.Test;

import domain.Matriz;

public class NumerosAleatoriosTest {

	@Test
	public void test() {

		for (int i = 0; i < 100; i++) {

			Random rand = new Random();
			int n = rand.nextInt(2);
			System.out.println(n);
		}

	}

	@Test
	public void test2() {
		Matriz matriz = new Matriz();
		int[][] matriz2 = matriz.getMatriz();

	}

}
