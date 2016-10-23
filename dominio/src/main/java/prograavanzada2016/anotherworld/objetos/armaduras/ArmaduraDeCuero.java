package prograavanzada2016.anotherworld.objetos.armaduras;

import prograavanzada2016.anotherworld.castas.Guerrero;

public class ArmaduraDeCuero extends ObjetoArmadura{
	public ArmaduraDeCuero(){
		this.setNombre("Armadura de cuero");
		this.setBonusDefensa(15);
		this.setCasta(new Guerrero());
		this.setNivelMinimo(2);
	}
}
