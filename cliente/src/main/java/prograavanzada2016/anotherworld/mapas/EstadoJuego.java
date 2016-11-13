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
		mundo = new Mundo(juego, "C:\\Users\\matut\\Desktop\\Prueba mapa de nuestro proyecto\\jrpg\\cliente\\src\\main\\resources\\mundoBasic.txt");
	    personaje = new Entidad(juego, mundo, 64, 64, 0, 0, Recursos.elfo, 150);
	}

	@Override
	public void actualizar() {
		mundo.actualizar();
		personaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		g.drawImage(Recursos.background, 0, 0, juego.getAncho(), juego.getAlto(), null);
		mundo.graficar(g);
		personaje.graficar(g);
		}
	
	public Entidad getPersonaje() {
		return personaje;
	}
}
