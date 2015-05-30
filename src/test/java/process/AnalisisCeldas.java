package process;

import org.junit.Assert;
import org.junit.Test;

public class AnalisisCeldas {

	int matriz[][] = { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } };

	int contadorDeUnos = 0;

	@Test
	public void test() {

		int fila = 1;
		int columna = 1;

		if (siTengoFilaArriba(fila)) {
			if (siTengoColumnaALaIzquierda(columna)) {
				sumarValorDeArribaALaIzquierda(fila, columna);
			}
			if (siTengoColumnaALaDerecha(columna)) {
				sumarArribaALaDerecha(fila, columna);
			}
			sumarElValorQueTengoArriba(fila, columna);
		}
		Assert.assertEquals(2, contadorDeUnos);

		if (siTengoColumnaALaIzquierda(columna)) {
			contadorDeUnos += matriz[fila][columna - 1];
			Assert.assertEquals(3, contadorDeUnos);
		}

		if (siTengoColumnaALaDerecha(columna)) {
			contadorDeUnos += matriz[fila][columna + 1];
			Assert.assertEquals(4, contadorDeUnos);
		}

		if (siTengoFilaAbajo(fila)) {
			if (siTengoColumnaALaIzquierda(columna)) {
				contadorDeUnos += matriz[fila + 1][columna - 1];
			}
			Assert.assertEquals(5, contadorDeUnos);

			if (siTengoColumnaALaDerecha(columna)) {
				contadorDeUnos += matriz[fila + 1][columna + 1];
			}
			Assert.assertEquals(6, contadorDeUnos);
			contadorDeUnos += matriz[fila + 1][columna];
			Assert.assertEquals(6, contadorDeUnos);
		}

	}

	private boolean siTengoFilaAbajo(int fila) {
		return (fila + 1) <= matriz.length;
	}

	private void sumarElValorQueTengoArriba(int fila, int columna) {
		contadorDeUnos += matriz[fila - 1][columna];
	}

	private void sumarArribaALaDerecha(int fila, int columna) {
		contadorDeUnos += matriz[fila - 1][columna + 1];
	}

	private boolean siTengoColumnaALaDerecha(int columna) {
		return columna + 1 <= matriz.length;
	}

	private void sumarValorDeArribaALaIzquierda(int fila, int columna) {
		contadorDeUnos += matriz[fila - 1][columna - 1];
	}

	private boolean siTengoColumnaALaIzquierda(int columna) {
		return (columna - 1) >= 0;
	}

	private boolean siTengoFilaArriba(int fila) {
		return (fila - 1) >= 0;
	}
}
