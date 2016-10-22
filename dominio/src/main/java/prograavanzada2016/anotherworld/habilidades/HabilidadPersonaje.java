package prograavanzada2016.anotherworld.habilidades;

import prograavanzada2016.anotherworld.castas.Casta;
import prograavanzada2016.anotherworld.entities.Ente;

public abstract class HabilidadPersonaje extends Habilidad{
	protected Casta casta;
	protected int nivelRequerido;

	public Casta getCasta() {
		return casta;
	}
	public void setCasta(Casta casta) {
		this.casta = casta;
	}
	public int getNivelRequerido() {
		return nivelRequerido;
	}
	public void setNivelRequerido(int nivelRequerido) {
		this.nivelRequerido = nivelRequerido;
	}
	
	
}
