package prograavanzada2016.anotherworld.castas;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.habilidades.BolaDeFuego;
import prograavanzada2016.anotherworld.habilidades.MisilArcano;
import prograavanzada2016.anotherworld.habilidades.NovaDeEscarcha;
import prograavanzada2016.anotherworld.razas.*;

public class Mago extends Casta{

	public Mago() {
		this.setNombre("Mago");
	}

	@Override
	public void saludar() {
		System.out.println("El conocimiento es poder");
		
	}

	@Override
	public void guardarHabilidades() {
		this.habilidades=new ArrayList<>();
		this.habilidades.add(new BolaDeFuego());
		this.habilidades.add(new NovaDeEscarcha());
		this.habilidades.add(new MisilArcano());
	}

	@Override
	public void calcularStats(Personaje personaje) {
		personaje.getRaza().calcularStats(personaje, this);
	}

}
