package domain;

import utils.FillStrategy;

import java.util.Arrays;
import java.util.Random;

public class Matriz {
    private int filas;
    private int columnas;
    private int matriz[][];//= { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 0 } };

    public Matriz(int filas, int columnas, FillStrategy fillStrategy) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = new int[filas][columnas];
        for (int row = 0; row < filas; row++) {
            for (int columns = 0; columns < columnas; columns++) {
                matriz[row][columns] = fillStrategy.getRandomValue();
            }
        }

    }

    public Matriz(int filas, int columnas, int matriz[][]) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = matriz;

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

    public void show() {
        for (int row = 0; row < filas; row++) {
            for (int columns = 0; columns < columnas; columns++) {
                System.out.print("["+matriz[row][columns]+"]");
            }
            System.out.println("");
        }
    }
}
