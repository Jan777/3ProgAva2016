package prograavanzada2016.anotherworld.objetos;

import prograavanzada2016.anotherworld.castas.Guerrero;

public class EspadaDeMadera extends ObjetoArma{
	public EspadaDeMadera(){
		this.setNombre("Espada de madera");
		this.setBonusAtaque(10);
		this.setPuntosDeEnergiaPorAtaque(20);
		this.setCasta(new Guerrero());
		this.setNivelMinimo(2);
	}
}
