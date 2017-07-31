package service;

import domain.Matriz;

/**
 * Created by tapia on 04/07/17.
 */
public class MatrizService {

    int contadorDeUnos;
    private Matriz matriz;

    public MatrizService() {
    }

    public int aplicarReglas(int vecinos, int celula) {
        if (vecinos > 3) {
            return 0;
        }
        if (vecinos == 3) {
            return 1;
        }
        if (vecinos == 2) {
            return celula;
        }
        if (vecinos < 2) {
            return 0;
        }
        return 1;
    }


    public int analisar(int fila, int columna) {
        if (siTengoFilaArriba(fila) && siTengoColumnaALaIzquierda(columna)) {
            sumarValorDeArribaALaIzquierda(fila, columna);
        }
        if (siTengoFilaArriba(fila) && siTengoColumnaALaDerecha(columna)) {
            sumarArribaALaDerecha(fila, columna);
        }
        if (siTengoFilaArriba(fila)) {
            sumarElValorQueTengoArriba(fila, columna);
        }
        if (siTengoColumnaALaIzquierda(columna)) {
            sumarElValorQueTengoALaIzquierda(fila, columna);
        }
        if (siTengoColumnaALaDerecha(columna)) {
            sumarElValorQueTengoALaDerecha(fila, columna);
        }
        if (siTengoFilaAbajo(fila) && siTengoColumnaALaIzquierda(columna)) {
            sumarValorAbajoALaIzquierda(fila, columna);
        }
        if (siTengoFilaAbajo(fila) && siTengoColumnaALaDerecha(columna)) {
            sumarValorAbajoALaDerecha(fila, columna);
        }
        if (siTengoFilaAbajo(fila)) {
            sumarValorDeAbajo(fila, columna);
        }
        return contadorDeUnos;
    }


    private void sumarValorDeAbajo(int fila, int columna) {
        contadorDeUnos += matriz.getValue(fila + 1,columna);
    }

    private void sumarValorAbajoALaDerecha(int fila, int columna) {
        contadorDeUnos += matriz.getValue(fila + 1,columna + 1);
    }

    private void sumarValorAbajoALaIzquierda(int fila, int columna) {
        contadorDeUnos += matriz.getValue(fila + 1,columna - 1);
    }

    private void sumarElValorQueTengoALaDerecha(int fila, int columna) {
        contadorDeUnos += matriz.getValue(fila,columna + 1);
    }

    private void sumarElValorQueTengoALaIzquierda(int fila, int columna) {
        contadorDeUnos += matriz.getValue(fila,columna - 1);
    }

    private void sumarElValorQueTengoArriba(int fila, int columna) {
        contadorDeUnos += matriz.getValue(fila - 1,columna);
    }

    private void sumarArribaALaDerecha(int fila, int columna) {
        contadorDeUnos += matriz.getValue(fila - 1,columna + 1);
    }

    private void sumarValorDeArribaALaIzquierda(int fila, int columna) {
        contadorDeUnos += matriz.getValue(fila - 1,columna - 1);
    }

    private boolean siTengoColumnaALaIzquierda(int columna) {
        return (columna - 1) >= 0;
    }

    private boolean siTengoFilaArriba(int fila) {
        return (fila - 1) >= 0;
    }

    private boolean siTengoFilaAbajo(int fila) {
        return (fila + 1) < matriz.getFilas();
    }

    private boolean siTengoColumnaALaDerecha(int columna) {
        return (columna + 1) < matriz.getColumnas();
    }

    public Matriz generar(Matriz matriz) {
        this.matriz = matriz;
        int filas = matriz.getFilas();
        int columnas = matriz.getColumnas();
        int[][] newMatriz = new int[filas][columnas];

        for (int row = 0; row < filas; row++) {
            for (int columns = 0; columns < columnas; columns++) {
                int vecinos = analisar(row, columns);
                this.contadorDeUnos=0;
                int nuevaCelula = aplicarReglas(vecinos, matriz.getValue(row, columns));
                newMatriz[row][columns] = nuevaCelula;
            }
        }
        return new Matriz(filas, columnas,newMatriz);
    }
}
