package service;

/**
 * Created by tapia on 04/07/17.
 */
public class MatrizService {

    int contadorDeUnos;
    private int[][] matriz;

    public MatrizService( int[][] matriz) {
        this.matriz = matriz;
    }


    private void analisar(int fila, int columna) {
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
    }


    private void sumarValorDeAbajo(int fila, int columna) {
        contadorDeUnos += matriz[fila + 1][columna];
    }

    private void sumarValorAbajoALaDerecha(int fila, int columna) {
        contadorDeUnos += matriz[fila + 1][columna + 1];
    }

    private void sumarValorAbajoALaIzquierda(int fila, int columna) {
        contadorDeUnos += matriz[fila + 1][columna - 1];
    }

    private void sumarElValorQueTengoALaDerecha(int fila, int columna) {
        contadorDeUnos += matriz[fila][columna + 1];
    }

    private void sumarElValorQueTengoALaIzquierda(int fila, int columna) {
        contadorDeUnos += matriz[fila][columna - 1];
    }

    private void sumarElValorQueTengoArriba(int fila, int columna) {
        contadorDeUnos += matriz[fila - 1][columna];
    }

    private void sumarArribaALaDerecha(int fila, int columna) {
        contadorDeUnos += matriz[fila - 1][columna + 1];
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

    private boolean siTengoFilaAbajo(int fila) {
        return (fila + 1) <= matriz.length;
    }

    private boolean siTengoColumnaALaDerecha(int columna) {
        return (columna + 1) <= matriz.length;
    }
}
