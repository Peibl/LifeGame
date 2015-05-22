package views;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import domain.Matriz;

public class LifeGameMainView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2093811644869322876L;
	private Timer timer;
	private PanelParaDibujar panelParaDibujar;

	public LifeGameMainView() {

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
		timer = new Timer(50, this);
		timer.start();

	}

	public void actionPerformed(ActionEvent e) {

		panelParaDibujar.repaint();
	}

}
