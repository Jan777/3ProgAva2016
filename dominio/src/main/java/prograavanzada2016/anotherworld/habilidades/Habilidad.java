package prograavanzada2016.anotherworld.habilidades;

import prograavanzada2016.anotherworld.castas.Casta;
import prograavanzada2016.anotherworld.entities.Ente;

public abstract class Habilidad{
	protected int id;
	protected int costeMana;
	protected Casta casta;
	protected int nivelRequerido;
	public abstract void LanzarHechizo(Ente enteLanzador, Ente enteObjetivo);
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCosteMana() {
		return costeMana;
	}
	public void setCosteMana(int costeMana) {
		this.costeMana = costeMana;
	}
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
