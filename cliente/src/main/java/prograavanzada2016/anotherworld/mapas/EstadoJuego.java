package prograavanzada2016.anotherworld.mapas;

import java.awt.Color;
import java.awt.Graphics;

import prograavanzada2016.anotherworld.juego.*;
import prograavanzada2016.anotherworld.utilities.*;

public class EstadoJuego extends Estado {

	private Entidad personaje;
	private Mundo mundo;

	public EstadoJuego(Game juego) {
		super(juego);
		mundo = new Mundo(juego,"c:\\GitAvanzada\\PrograAvanzada\\jrpg\\cliente\\src\\main\\resources\\mundoBasic.txt");
		//mundo = new Mundo(juego, "\\mundoBasic.txt"); //Aca construimos nuestro mundo según la matriz en mundoBasic.txt
	    personaje = new Entidad(juego, mundo, 64, 64, 0, 0, Recursos.humano, 150); //Aca construimos nuestro personaje segun el personaje del jugador
	}

	@Override
	public void actualizar() {
		mundo.actualizar();
		personaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		//g.drawImage(Recursos.background, 0, 0, juego.getAncho(), juego.getAlto(), null);
		g.setColor(Color.black);
		g.fillRect(0, 0, juego.getAncho(), juego.getAlto());
		mundo.graficar(g);
		personaje.graficar(g);
		}
	
	public Entidad getPersonaje() {
		return personaje;
	}
}
