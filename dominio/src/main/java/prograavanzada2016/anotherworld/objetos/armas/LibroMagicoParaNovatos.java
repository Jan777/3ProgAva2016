package prograavanzada2016.anotherworld.objetos.armas;

import prograavanzada2016.anotherworld.castas.Curandero;

public class LibroMagicoParaNovatos extends ObjetoArma{
	public LibroMagicoParaNovatos(){
		this.setNombre("Libro magico para principiantes");
		this.setBonusAtaque(10);
		this.setPuntosDeEnergiaPorAtaque(5);
		this.setCasta(new Curandero());
	}
}
