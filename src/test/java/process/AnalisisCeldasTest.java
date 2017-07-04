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

        Assert.assertEquals(0, aplicarReglas(0, 1));
        Assert.assertEquals(0, aplicarReglas(0, 0));

        Assert.assertEquals(0, aplicarReglas(1, 1));
        Assert.assertEquals(0, aplicarReglas(1, 0));

        Assert.assertEquals(1, aplicarReglas(2, 1));
        Assert.assertEquals(0, aplicarReglas(2, 0));

        Assert.assertEquals(1, aplicarReglas(3, 1));
        Assert.assertEquals(1, aplicarReglas(3, 0));

        Assert.assertEquals(0, aplicarReglas(4, 1));
        Assert.assertEquals(0, aplicarReglas(4, 0));

        Assert.assertEquals(0, aplicarReglas(5, 1));
        Assert.assertEquals(0, aplicarReglas(5, 0));

        Assert.assertEquals(0, aplicarReglas(6, 1));
        Assert.assertEquals(0, aplicarReglas(6, 0));

        Assert.assertEquals(0, aplicarReglas(7, 1));
        Assert.assertEquals(0, aplicarReglas(7, 0));

        Assert.assertEquals(0, aplicarReglas(8, 1));
        Assert.assertEquals(0, aplicarReglas(8, 0));

    }

    private int aplicarReglas(int vecinos, int celula) {
        int result=1;
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
            if (celula==0)  result = 0;
        }
        return result;
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
