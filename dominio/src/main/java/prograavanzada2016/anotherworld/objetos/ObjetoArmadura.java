package prograavanzada2016.anotherworld.objetos;

import prograavanzada2016.anotherworld.castas.Casta;

public abstract class ObjetoArmadura extends Objeto{
	protected int bonusDefensa;

	public int getBonusDefensa() {
		return bonusDefensa;
	}

	public void setBonusDefensa(int bonusDefensa) {
		this.bonusDefensa = bonusDefensa;
	}
}
