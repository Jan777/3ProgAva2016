package prograavanzada2016.anotherworld.castas;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.enumvalues.TipoCasta;
import prograavanzada2016.anotherworld.razas.Raza;

public abstract class Casta {
	protected TipoCasta tipoCasta;
	
	public Casta(TipoCasta tipoCasta){
		this.tipoCasta=tipoCasta;
	}
	
	
	
	public TipoCasta getTipoCasta() {
		return tipoCasta;
	}



	public void setTipoCasta(TipoCasta tipoCasta) {
		this.tipoCasta = tipoCasta;
	}

	public abstract void calcularStats(Personaje personaje, Raza raza) throws Exception;
	
	public void aumentarStatsSegunCasta(Personaje personaje, int fuerza, int destreza, int inteligencia, int salud, int mana, int energia){
		personaje.aumentarFuerza(fuerza);
		personaje.aumentarDestreza(destreza);
		personaje.aumentarInteligencia(inteligencia);
		personaje.aumentarSalud(salud);
		personaje.aumentarMana(mana);
		personaje.aumentarEnergia(energia);
	}
}
