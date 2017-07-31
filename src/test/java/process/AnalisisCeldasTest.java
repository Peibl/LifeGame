package process;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.MatrizService;

public class AnalisisCeldasTest {

    int matriz[][] = {{1, 0, 1}, {1, 1, 1}, {1, 0, 1}};

    MatrizService matrizService;


    @Before
    public void setUp() throws Exception {
        matrizService = new MatrizService();
    }

    @Test
    public void test() {
        int fila = 1;
        int columna = 1;
        int contadorDeUnos = matrizService.analisar(fila, columna);
        Assert.assertEquals(6, contadorDeUnos);


    }

    @Test
    public void test2() {
        int fila = 0;
        int columna = 0;
        int contadorDeUnos = matrizService.analisar(fila, columna);
        Assert.assertEquals(2, contadorDeUnos);

    }

    @Test
    public void rules() throws Exception {

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
        return matrizService.aplicarReglas(vecinos, celula);
    }

}
