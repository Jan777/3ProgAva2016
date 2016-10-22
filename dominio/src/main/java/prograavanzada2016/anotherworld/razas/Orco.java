package prograavanzada2016.anotherworld.razas;

import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.entities.Personaje;

public class Orco extends Raza{

	public Orco() {
	}

	@Override
	public void calcularStats(Personaje personaje, Mago mago) {
		this.aumentarStatsSegunCasta(personaje, 0, 5, 3, 150, 100, 50);
	}

	@Override
	public void calcularStats(Personaje personaje, Guerrero guerrero) {
		this.aumentarStatsSegunCasta(personaje, 5, 10, 0, 100, 0, 100);		
	}

	@Override
	public void calcularStats(Personaje personaje, Curandero curandero) {
		this.aumentarStatsSegunCasta(personaje, 0, 0, 10, 250, 150, 50);
	}
	
}
