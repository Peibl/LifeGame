package views;

import domain.Matriz;
import service.MatrizService;

import javax.swing.*;
import java.awt.*;

public class LifeGameMainView extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -2093811644869322876L;
    private Timer timer;
    private PanelParaDibujar panelParaDibujar;
    Matriz mat = new Matriz(200, 200);
    MatrizService matrizService = new MatrizService();

    public LifeGameMainView() throws InterruptedException {

        super("robot-snake-fight");

        this.setBounds(0, 0, 810, 610);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(null);

        panelParaDibujar = new PanelParaDibujar();
        panelParaDibujar.updateMatriz(new Matriz(1000, 1000));
        panelParaDibujar.setBounds(0, 0, 800, 600);
        container.add(panelParaDibujar);

        this.setContentPane(container);
        this.setVisible(true);
        run3();

    }


    public void run3() throws InterruptedException {
        long interacciones=0;
        while (true) {
            Thread.sleep(10);
            panelParaDibujar.updateMatriz(mat);
            panelParaDibujar.paintComponent(panelParaDibujar.getGraphics());
            this.mat = matrizService.generar(mat);
            interacciones+=1;
            this.setTitle(String.valueOf(interacciones));
        }


    }
}
