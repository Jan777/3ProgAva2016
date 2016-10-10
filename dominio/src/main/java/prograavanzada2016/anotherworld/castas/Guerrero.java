package prograavanzada2016.anotherworld.castas;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.razas.*;

public class Guerrero extends Casta{

	public Guerrero() {
	}

	@Override
	public void calcularStats(Personaje personaje) {
		if(personaje.getRaza() instanceof Orco){
			this.aumentarStatsSegunCasta(personaje, 5, 10, 0, 100, 0, 100);
		}else{
			this.aumentarStatsSegunCasta(personaje, 10, 5, 0, 200, 0, 50);
		}
	}

	@Override
	public void saludar() {
		System.out.println("victoria o muerte");
		
	}

}
