package prograavanzada2016.anotherworld.castas;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.habilidades.BolaDeFuego;
import prograavanzada2016.anotherworld.habilidades.NovaDeEscarcha;
import prograavanzada2016.anotherworld.razas.*;

public class Mago extends Casta{

	public Mago() {
		this.setNombre("Mago");
		//this.guardarHabilidades();
	}

	@Override	
	public void calcularStats(Personaje personaje) {
		if(personaje.getRaza() instanceof Orco){
			this.aumentarStatsSegunCasta(personaje, 0, 5, 3, 150, 100, 50);
		}else{
			this.aumentarStatsSegunCasta(personaje, 0, 10, 3, 50, 200, 50);
		}
	}

	@Override
	public void saludar() {
		System.out.println("Las turbulencias de magia estan alterandose");
		
	}

	@Override
	public void guardarHabilidades() {
		this.habilidades=new ArrayList<>();
		this.habilidades.add(new BolaDeFuego());
		this.habilidades.add(new NovaDeEscarcha());
	}

}
