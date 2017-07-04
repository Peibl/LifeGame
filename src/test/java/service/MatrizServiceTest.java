package service;

import domain.Matriz;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tapia on 04/07/17.
 */
public class MatrizServiceTest {

    @Test
    public void testService() throws Exception {
        Matriz matriz = new Matriz();
        MatrizService matrizService = new MatrizService(matriz.getMatriz());




    }
}