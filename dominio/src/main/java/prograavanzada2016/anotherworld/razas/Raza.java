package prograavanzada2016.anotherworld.razas;

import prograavanzada2016.anotherworld.entities.Personaje;

public abstract class Raza implements ICalculaStats{
	
	protected int id;
	
	public Raza(){}
	
	protected void aumentarStatsSegunCasta(Personaje personaje, int fuerza, int destreza, int inteligencia, int salud, int mana, int energia){
		personaje.aumentarFuerza(fuerza);
		personaje.aumentarDestreza(destreza);
		personaje.aumentarInteligencia(inteligencia);
		personaje.aumentarSalud(salud);
		personaje.aumentarMana(mana);
		personaje.aumentarEnergia(energia);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
