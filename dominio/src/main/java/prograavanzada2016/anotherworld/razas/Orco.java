package prograavanzada2016.anotherworld.razas;

import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.entities.Personaje;

public class Orco extends Raza{
	

	public Orco() {
		
		id = 1;
	}

	@Override
	public void calcularStats(Personaje personaje, Mago mago) throws Exception {
		this.aumentarStatsSegunCasta(personaje, 0, 5, 3, 150, 100, 50);
	}

	@Override
	public void calcularStats(Personaje personaje, Guerrero guerrero) throws Exception{
		this.aumentarStatsSegunCasta(personaje, 5, 10, 0, 100, 0, 100);		
	}

	@Override
	public void calcularStats(Personaje personaje, Curandero curandero) throws Exception {
		this.aumentarStatsSegunCasta(personaje, 0, 0, 10, 250, 150, 50);
	}
	
}
