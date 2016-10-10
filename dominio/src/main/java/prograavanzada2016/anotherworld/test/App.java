package prograavanzada2016.anotherworld.test;

import prograavanzada2016.anotherworld.castas.*;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.objetos.armaduras.ArmaduraDeCuero;
import prograavanzada2016.anotherworld.objetos.armas.Einlanzer;
import prograavanzada2016.anotherworld.objetos.armas.EspadaDeMadera;
import prograavanzada2016.anotherworld.objetos.armas.LibroMagicoParaNovatos;
import prograavanzada2016.anotherworld.razas.*;

public class App {

	public static void main(String[] args) throws Exception {
		Personaje p1 = new Personaje("pedro", new Orco(), new Curandero());
		Personaje p2 = new Personaje("pedro", new Orco(), new Mago());
		Personaje p3 = new Personaje("pedro", new Orco(), new Guerrero());
		p1.mostrarStats();
		p2.mostrarStats();
		System.out.println("**********************");
		p1.equiparArma(new LibroMagicoParaNovatos());
		p1.atacar(p2);
		p1.atacar(p2);
		p1.atacar(p2);
		p1.atacar(p2);
		p2.mostrarStats();
		//p2.mostrarStats();
		//System.out.println("**********************");
		/*p1.equiparArma(new EspadaDeMadera());
		p2.equiparArmadura(new ArmaduraDeCuero());
		p1.atacar(p2);
		p1.mostrarStats();
		System.out.println("**********************");
		p2.mostrarStats();*/
	}

}
