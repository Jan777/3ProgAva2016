package prograavanzada2016.anotherworld.objetos;

import prograavanzada2016.anotherworld.castas.Guerrero;

public class ArmaduraDeCuero extends ObjetoArmadura{
	public ArmaduraDeCuero() throws Exception{
		this.setNombre("Armadura de cuero");
		this.setBonusDefensa(15);
		this.setCasta(new Guerrero());
		this.setNivelMinimo(2);
	}
}
