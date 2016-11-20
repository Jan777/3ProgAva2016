package prograavanzada2016.anotherworld.mapas;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import prograavanzada2016.anotherworld.juego.*;
import prograavanzada2016.anotherworld.utilities.*;

public class EstadoJuego extends Estado {

	private Entidad personaje;
	private Mundo mundo;
	private boolean pruebita = true;
	private ArrayList<Entidad> personajes;
	
	public EstadoJuego(Game juego) throws FileNotFoundException, IOException {
		super(juego);
		this.personajes = new ArrayList<>();
		Properties propiedades = new Properties();
		propiedades.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\cfg.properties"));
		//mundo = new Mundo(juego, propiedades.getProperty("mundoMati"));
		mundo = new Mundo(juego,"c:\\GitAvanzada\\PrograAvanzada\\jrpg\\cliente\\src\\main\\resources\\mundoBasic.txt");
		//mundo = new Mundo(juego, "C:\\Users\\matut\\jrpg\\cliente\\src\\main\\resources\\mundoBasic.txt"); //Aca construimos nuestro mundo seg�n la matriz en mundoBasic.txt
		if(juego.getUser().getPersonaje().getRazaId() == 1){ //Aca construimos nuestro personaje segun el personaje del jugador
			personaje = new Entidad(juego, mundo, 64, 64, 0, 0, Recursos.elfo, 150);
		} else if (juego.getUser().getPersonaje().getRazaId() == 2){
			personaje = new Entidad(juego, mundo, 64, 64, 0, 0, Recursos.humano, 150);
		}
	}

	@Override
	public void actualizar() {
		mundo.actualizar();
		personaje.actualizar();
		for(Entidad otroPersonaje : personajes){
			if(pruebita){
				otroPersonaje.setxAutomatico(300);
				otroPersonaje.setyAutomatico(300);
				pruebita=false;
			}
			otroPersonaje.actualizar();
		}
		
	}

	@Override
	public void graficar(Graphics g) {
		//g.drawImage(Recursos.background, 0, 0, juego.getAncho(), juego.getAlto(), null);
		g.setColor(Color.black);
		g.fillRect(0, 0, juego.getAncho(), juego.getAlto());
		mundo.graficar(g);
		personaje.graficar(g);
		for(Entidad otroPersonaje : personajes){
			otroPersonaje.graficar(g);
		}
	}
	
	public Entidad getPersonaje() {
		return personaje;
	}
	
	public void addOtroPersonaje(Entidad otroPersonaje){
		otroPersonaje.setMundo(this.mundo);
		this.personajes.add(otroPersonaje);
	}
}
