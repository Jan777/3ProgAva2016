package prograavanzada2016.anotherworld.objetos.armaduras;

import prograavanzada2016.anotherworld.castas.Casta;

public abstract class ObjetoArmadura {
	protected String nombre;
	protected int bonusDefensa;
	protected Casta casta;
	protected int nivelMinimo;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getBonusDefensa() {
		return bonusDefensa;
	}

	public void setBonusDefensa(int bonusDefensa) {
		this.bonusDefensa = bonusDefensa;
	}

	public Casta getCasta() {
		return casta;
	}

	public void setCasta(Casta casta) {
		this.casta = casta;
	}

	public int getNivelMinimo() {
		return nivelMinimo;
	}

	public void setNivelMinimo(int nivelMinimo) {
		this.nivelMinimo = nivelMinimo;
	}
	
	
}
