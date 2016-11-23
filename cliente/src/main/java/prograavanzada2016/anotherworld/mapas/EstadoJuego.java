package prograavanzada2016.anotherworld.mapas;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import prograavanzada2016.anotherworld.juego.*;
import prograavanzada2016.anotherworld.modelos.InteligenciaArtificial;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.resources.Propiedades;
import prograavanzada2016.anotherworld.utilities.*;

public class EstadoJuego extends Estado {

	private Entidad personaje;
	private Mundo mundo;
	private boolean pruebita = true;
	private ArrayList<Entidad> personajes;
	private ArrayList<Entidad> enemigos;
	
	public EstadoJuego(Game juego) throws Exception {
		super(juego);
		this.personajes = new ArrayList<>();
		this.enemigos = new ArrayList<>();
		Propiedades propiedades = Propiedades.getInstance();
		mundo = new Mundo(juego, propiedades.getProperty("mundo"));
		
		if(juego.getUser().getPersonaje().getRazaId() == 1){ //Aca construimos nuestro personaje segun el personaje del jugador
			personaje = new Entidad(juego, mundo, 64, 64, 0, 0, Recursos.elfo, 150);
		} else if (juego.getUser().getPersonaje().getRazaId() == 2){
			personaje = new Entidad(juego, mundo, 64, 64, 0, 0, Recursos.humano, 150);
		}
		this.personaje.setUsuario(juego.getUser());
	}

	@Override
	public void actualizar() {
		mundo.actualizar();
		personaje.actualizar();
		for(Entidad otroPersonaje : personajes){
			otroPersonaje.actualizar();
		}
		for(Entidad enemigo : enemigos){
			enemigo.actualizar();
		}
	}

	@Override
	public void graficar(Graphics g) {
		//g.drawImage(Recursos.background, 0, 0, juego.getAncho(), juego.getAlto(), null);
		g.setColor(Color.black);
		g.fillRect(0, 0, juego.getAncho(), juego.getAlto());
		try {
			mundo.graficar(g);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personaje.graficar(g);
		for(Entidad otroPersonaje : personajes){
			otroPersonaje.graficar(g);
		}
		for(Entidad enemigo : enemigos){
			enemigo.graficar(g);
		}
	}
	
	public Entidad getPersonaje() {
		return personaje;
	}
	@Override
	public void addOtroPersonaje(Entidad otroPersonaje,Usuario usuario){
		otroPersonaje.setMundo(this.mundo);
		otroPersonaje.setUsuario(usuario);
		this.personajes.add(otroPersonaje);
	}

	public ArrayList<Entidad> getPersonajes() {
		return this.personajes;
	}

	public ArrayList<Entidad> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(ArrayList<Entidad> enemigos) {
		this.enemigos = enemigos;
	}
	
	@Override
	public void addOtroEnemigo(Entidad enemigo,Usuario usuario){
		enemigo.setMundo(this.mundo);
		enemigo.setUsuario(usuario);
		this.enemigos.add(enemigo);
	}
}
