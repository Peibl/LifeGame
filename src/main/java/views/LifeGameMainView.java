package views;

import domain.Matriz;

import javax.swing.*;
import java.awt.*;

public class LifeGameMainView extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2093811644869322876L;
    private Timer timer;
	private PanelParaDibujar panelParaDibujar;

	public LifeGameMainView() throws InterruptedException {

		super("robot-snake-fight");

		this.setBounds(0, 0, 810, 610);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = this.getContentPane();
		container.setLayout(null);

		panelParaDibujar = new PanelParaDibujar();
		panelParaDibujar.updateMatriz(new Matriz());
		panelParaDibujar.setBounds(0, 0, 810, 610);
		container.add(panelParaDibujar);

		this.setContentPane(container);
		this.setVisible(true);
		run3();

	}


    public void run3() throws InterruptedException {
    while (true){
        Thread.sleep(1000);
        Matriz mat=new Matriz();
        System.out.println(mat.toString());
        panelParaDibujar.updateMatriz(mat);
        panelParaDibujar.paintComponent(panelParaDibujar.getGraphics());
    }


    }
}
