package views;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import domain.Matriz;

public class PanelParaDibujar extends JPanel {

	private static final long serialVersionUID = 2721705475191274007L;
	private Matriz mat;

	public PanelParaDibujar() {

		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics graphic) {

		int width = this.getWidth();
		int height = this.getHeight();

		int colums = mat.getColumnas();
		int rows = mat.getFilas();

		Double x = (double) (width / colums);
		Double y = (double) (height / rows);

		int cantidasDeCubosenHorizontal = colums % width;
		int cantidasDeCubosenVertical = rows % height;

		int xInicial = 10;
		int yInicial = 10;

		for (int i = 0; i < cantidasDeCubosenHorizontal; i++) {
			yInicial = 10;
			for (int i2 = 0; i2 < cantidasDeCubosenVertical; i2++) {

				if (mat.getValue(i, i2) == 0) {

					graphic.setColor(Color.BLACK);
				} else {
					graphic.setColor(Color.WHITE);
				}
				graphic.fillRect(xInicial, yInicial, x.intValue(), y.intValue());
				yInicial += y;

			}
			xInicial += x;

		}

	}

	public void updateMatriz(Matriz mat) {
		this.mat = mat;

	}

}