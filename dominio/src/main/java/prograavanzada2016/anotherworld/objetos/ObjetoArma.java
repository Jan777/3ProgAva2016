package prograavanzada2016.anotherworld.objetos;

import prograavanzada2016.anotherworld.castas.Casta;
public abstract class ObjetoArma extends Objeto {
	protected int bonusAtaque;
	protected int puntosDeEnergiaPorAtaque;
	
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
}
