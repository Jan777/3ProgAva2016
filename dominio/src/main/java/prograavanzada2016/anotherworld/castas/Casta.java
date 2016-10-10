package prograavanzada2016.anotherworld.castas;

import prograavanzada2016.anotherworld.entities.Personaje;

public abstract class Casta {

	public abstract void calcularStats(Personaje personaje) throws Exception;
	
	public abstract void saludar();
	
	protected void aumentarStatsSegunCasta(Personaje personaje, int fuerza, int destreza, int inteligencia, int salud, int mana, int energia){
		personaje.aumentarFuerza(fuerza);
		personaje.aumentarDestreza(destreza);
		personaje.aumentarInteligencia(inteligencia);
		personaje.aumentarSalud(salud);
		personaje.aumentarMana(mana);
		personaje.aumentarEnergia(energia);
	}
}
