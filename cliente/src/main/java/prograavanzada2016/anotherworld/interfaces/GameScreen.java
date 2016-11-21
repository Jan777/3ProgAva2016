package prograavanzada2016.anotherworld.interfaces;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JToolBar;

public class GameScreen {

	public JFrame pantalla;
	private Canvas canvas; // Aca donde se grafica el juego

	public GameScreen(final String nombre, final int ancho, final int alto) {
		/*
		pantalla = new JFrame(nombre);
		pantalla.setSize(396, 229);
		pantalla.setResizable(false);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setLocationRelativeTo(null);
		pantalla.setVisible(true);
		   */ 
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(ancho, alto));
		canvas.setMaximumSize(new Dimension(ancho, alto));
		canvas.setMinimumSize(new Dimension(ancho, alto));
		canvas.setFocusable(false);
		
		//pantalla.getContentPane().add(canvas);
		
		//JToolBar toolBar = new JToolBar();
		//pantalla.getContentPane().add(toolBar, BorderLayout.NORTH);
		//pantalla.pack();
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return pantalla;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	
}
