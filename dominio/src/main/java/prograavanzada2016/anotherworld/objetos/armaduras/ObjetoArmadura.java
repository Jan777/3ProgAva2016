package prograavanzada2016.anotherworld.objetos.armaduras;

public abstract class ObjetoArmadura {
	protected String nombre;
	protected int bonusDefensa;
	
	
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
	
	
}
