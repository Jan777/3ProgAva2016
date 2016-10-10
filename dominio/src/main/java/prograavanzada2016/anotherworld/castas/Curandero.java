package prograavanzada2016.anotherworld.castas;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.razas.*;

public class Curandero extends Casta {

	public Curandero(){
	}

	@Override
	public void calcularStats(Personaje p) {
		this.calcularStats(p,p.getRaza());
	}

	public void calcularStats(Personaje personaje, Raza raza) {
		if(raza instanceof Orco){
			this.aumentarStatsSegunCasta(personaje, 0, 0, 10, 250, 150, 50);
		}else{
			this.aumentarStatsSegunCasta(personaje, 0, 0, 15, 150, 200, 50);
		}
	}

	public void calcularStats(Humano humano) {
		//this.aumentarStatsSegunCasta(personaje, 0, 0, 15, 150, 200, 50);
	}

	@Override
	public void saludar() {
		System.out.println("La luz es el camino");
	}
}
