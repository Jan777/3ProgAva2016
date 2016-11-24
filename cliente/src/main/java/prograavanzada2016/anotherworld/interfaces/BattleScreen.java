package prograavanzada2016.anotherworld.interfaces;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import prograavanzada2016.anotherworld.resources.Propiedades;

public class BattleScreen extends Canvas{
	Propiedades prop;
	public BattleScreen() {
		this.setVisible(true);
		this.setSize(800,450);
		this.setBackground(Color.BLACK);
	}
	@Override
	public void paint(Graphics g){		
		//tablero
		g.setColor(Color.BLUE);
		g.fill3DRect(0, 200, 200, 100, false);
		g.fill3DRect(600, 200, 200, 100, false);
		g.fill3DRect(200, 0, 400, 300, false);
		
		//palabra 200 600 0 300
		g.setColor(Color.RED);
		//LETRA V
		g.fill3DRect(267, 100, 11, 25, false);
		g.fill3DRect(278, 125, 11, 50, false);
		g.fill3DRect(289, 175, 11, 30, false);
		g.fill3DRect(311, 100, 11, 25, false);
		g.fill3DRect(300, 125, 11, 50, false);
		
		//LETRA S
		g.fill3DRect(440, 100, 60, 10, false);
		g.fill3DRect(430, 110, 10, 10, false);
		g.fill3DRect(420, 120, 10, 30, false);
		g.fill3DRect(430, 150, 70, 10, false);
		g.fill3DRect(500, 160, 10, 10, false);
		g.fill3DRect(510, 170, 10, 30,false);
		g.fill3DRect(440, 200, 70, 10, false);
		
		//pasto
		g.setColor(Color.GREEN);
		g.fill3DRect(0, 300, 800, 450, false);
		
		
		//player 1
		g.setColor(Color.ORANGE);
		g.fill3DRect(200, 350, 25, 25, false);
		g.setColor(Color.BLACK);
		g.drawString("Jugador 1",190,390);
		//player 2
		g.setColor(Color.YELLOW);
		g.fill3DRect(600, 350, 25, 25, false);
		g.setColor(Color.BLACK);
		g.drawString("Minotauro",590,390);
	}
}
