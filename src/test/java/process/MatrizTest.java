package process;

import org.junit.Test;

public class MatrizTest {

	@Test
	public void test() {
		int width = 600;
		int height = 300;

		int colums = 3;
		int rows = 3;

		Double x = (double) (width / colums);
		Double y = (double) (height / rows);

		int cantidasDeCubosenHorizontal = colums % width;
		int cantidasDeCubosenVertical = rows % height;

		System.out.println(cantidasDeCubosenHorizontal);
		System.out.println(cantidasDeCubosenVertical);

		System.out.println(x.intValue());
		System.out.println(y.intValue());
		int xInicial = 0;
		int yInicial = 0;

		for (int i = 0; i < cantidasDeCubosenHorizontal; i++) {
			for (int i2 = 0; i2 < cantidasDeCubosenVertical; i2++) {
				System.out.println("cuadrado: x=" + xInicial + " y=" + yInicial
						+ " width=" + x + " height=" + y);
				yInicial += y;

			}
			xInicial += x;

		}
	}
}
