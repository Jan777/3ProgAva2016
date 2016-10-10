package prograavanzada2016.anotherworld.objetos.armas;

import prograavanzada2016.anotherworld.castas.Casta;

public abstract class ObjetoArma {
	protected String nombre;
	protected int bonusAtaque;
	protected int puntosDeEnergiaPorAtaque;
	protected Casta casta;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getBonusAtaque() {
		return bonusAtaque;
	}
	public void setBonusAtaque(int bonusAtaque) {
		this.bonusAtaque = bonusAtaque;
	}
	public int getPuntosDeEnergiaPorAtaque() {
		return puntosDeEnergiaPorAtaque;
	}
	public void setPuntosDeEnergiaPorAtaque(int puntosDeEnergiaPorAtaque) {
		this.puntosDeEnergiaPorAtaque = puntosDeEnergiaPorAtaque;
	}
	public Casta getCasta() {
		return casta;
	}
	public void setCasta(Casta casta) {
		this.casta = casta;
	}	
}
