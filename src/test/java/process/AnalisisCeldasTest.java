package process;

import org.junit.Assert;
import org.junit.Test;

public class AnalisisCeldasTest {

    int matriz[][] = {{1, 0, 1}, {1, 1, 1}, {1, 0, 1}};

    int contadorDeUnos = 0;

    @Test
    public void test() {
        int fila = 1;
        int columna = 1;
        analisar(fila, columna);
        Assert.assertEquals(6, contadorDeUnos);

    }

    @Test
    public void test2() {
        int fila = 0;
        int columna = 0;
        analisar(fila, columna);
        Assert.assertEquals(2, contadorDeUnos);

    }

    @Test
    public void rules() throws Exception {
/*
        Si una célula viva tiene menos de dos vecinos vivos, muere.
        Si una célula viva tiene dos o tres vecinos vivos, permanece viva.
        Si una célula viva tiene más de tres vecinos vivos, muere.
        Si una célula muerta tiene exactamente tres vecinos vivos, se vuelve viva.*/


        int vecinos = 6;
        int celula = 1;
        int result;
        if (celula == 1 && vecinos < 2) {
            result = 0;
        }
        if (celula == 1 && (vecinos == 2 || vecinos == 3)) {
            result = 1;
        }
        if (celula == 1 && vecinos > 3) {
            result = 0;
        }
        if (celula == 0 && vecinos == 3) {
            result = 1;
        } else {
            result = 0;
        }


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
