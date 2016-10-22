package prograavanzada2016.anotherworld.castas;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.habilidades.Rodillazo;
import prograavanzada2016.anotherworld.razas.*;

public class Guerrero extends Casta{

	public Guerrero() {
		this.setNombre("Guerrero");
	}

	@Override
	public void saludar() {
		System.out.println("victoria o muerte");
		
	}

	@Override
	public void guardarHabilidades() {
		this.habilidades=new ArrayList<>();
		this.habilidades.add(new Rodillazo());
	}

	@Override
	public void calcularStats(Personaje personaje) {
		personaje.getRaza().calcularStats(personaje, this);
	}

}
