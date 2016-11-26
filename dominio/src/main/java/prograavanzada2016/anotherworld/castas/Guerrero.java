package prograavanzada2016.anotherworld.castas;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.habilidades.Rodillazo;
import prograavanzada2016.anotherworld.razas.*;

public class Guerrero extends Casta{

	public Guerrero() throws Exception {
		this.setNombre("Guerrero");
		id = 2;
	}

	@Override
	public void saludar() {
		//System.out.println("victoria o muerte");
		
	}

	@Override
	public void guardarHabilidades() throws Exception {
		this.habilidades=new ArrayList<>();
		this.habilidades.add(new Rodillazo());
	}

	@Override
	public void calcularStats(Personaje personaje) throws Exception {
		personaje.getRaza().calcularStats(personaje, this);
	}

}
