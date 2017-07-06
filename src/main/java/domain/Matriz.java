package domain;

import java.util.Random;

public class Matriz {
	private int filas = 200;
	private int columnas = 200;
	private int matriz[][] = { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 0 } };

	public Matriz() {
		Random rand = new Random();
		matriz = new int[filas][columnas];
		for (int row = 0; row < filas; row++) {
			for (int columns = 0; columns < columnas; columns++) {
				int n = rand.nextInt(2);
				matriz[row][columns] = n;
			}
		}

	}

	public int[][] getMatriz() {
		return matriz;
	}

	public int getColumnas() {
		return columnas;
	}

	public int getFilas() {
		return filas;
	}

	public int getValue(int row, int column) {
		return matriz[row][column];
	}

    @Override
    public String toString() {
        return super.toString();
    }
}
