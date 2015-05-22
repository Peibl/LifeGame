package process;

import org.junit.Test;

public class AnalisisCeldas {

	int matriz[][] = { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 0 } };

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

		System.out.println(contadorDeUnos);

	}

	private void sumarElValorQueTengoArriba(int fila, int columna) {
		contadorDeUnos += matriz[fila - 1][columna];
	}

	private void sumarArribaALaDerecha(int fila, int columna) {
		contadorDeUnos += matriz[fila - 1][columna + 1];
	}

	private boolean siTengoColumnaALaDerecha(int columna) {
		return columna + 1 > matriz.length;
	}

	private void sumarValorDeArribaALaIzquierda(int fila, int columna) {
		contadorDeUnos += matriz[fila - 1][columna - 1];
	}

	private boolean siTengoColumnaALaIzquierda(int columna) {
		return (columna - 1) > 0;
	}

	private boolean siTengoFilaArriba(int fila) {
		return (fila - 1) >= 0;
	}
}
