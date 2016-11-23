package prograavanzada2016.anotherworld.mapas;

import java.awt.Graphics;

import prograavanzada2016.anotherworld.juego.*;
import prograavanzada2016.anotherworld.modelos.Usuario;

public abstract class Estado {

	private static Estado estadoActual = null; // Estado para saber que actualizacion realizar
 
	protected Game juego;
	
	public Estado(Game juego) {
		this.juego = juego;
	}
	
	public abstract void actualizar();
	
	public abstract void graficar(Graphics g);
	
	public static void setEstado(Estado estado) {
		estadoActual = estado;
	}
	
	public static Estado getEstado() {
		return estadoActual;
	}
	
	public abstract void addOtroPersonaje(Entidad otroPersonaje,Usuario usuario);

	public abstract void addOtroEnemigo(Entidad enemigo, Usuario usuario);
}
