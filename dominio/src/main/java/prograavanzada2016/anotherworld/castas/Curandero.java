package prograavanzada2016.anotherworld.castas;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.habilidades.Curar;
import prograavanzada2016.anotherworld.razas.*;

public class Curandero extends Casta {

	public Curandero() throws Exception{
		this.setNombre("Curandero");
		id = 1;
	}
	
	@Override
	public void saludar() {
		System.out.println("La luz es el camino");
	}

	@Override
	public void guardarHabilidades() throws Exception {
		this.habilidades=new ArrayList<>();
		this.habilidades.add(new Curar());
	}

	@Override
	public void calcularStats(Personaje personaje) throws Exception {
		personaje.getRaza().calcularStats(personaje, this);
	}
}
