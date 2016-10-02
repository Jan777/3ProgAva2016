package prograavanzada2016.anotherworld.model;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.enumvalues.TipoCasta;

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



	public abstract void calcularStats(Personaje personaje, Raza raza);
}
