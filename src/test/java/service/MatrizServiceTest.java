package service;

import domain.Matriz;
import org.junit.Test;

/**
 * Created by tapia on 04/07/17.
 */
public class MatrizServiceTest {
    int matriz[][] = {{1, 0, 1}, {1, 0, 0}, {1, 0, 1}};

    @Test
    public void testService() throws Exception {
        Matriz matriz = new Matriz(200, 200);
        matriz.show();
        MatrizService matrizService = new MatrizService();

        for (int x = 0; x < 10; x++) {

            System.out.println("#################");
            matriz = matrizService.generar(matriz);
            matriz.show();
        }

    }
}