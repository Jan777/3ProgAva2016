package prograavanzada2016.anotherworld.razas;

import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.entities.Personaje;

public class Humano extends Raza{

	public Humano() throws Exception{
		
		id = 2;
	}

	@Override
	public void calcularStats(Personaje personaje, Mago mago) throws Exception{
		System.out.println("Soy mago humano");
		this.aumentarStatsSegunCasta(personaje, 0, 10, 3, 50, 200, 50);
	}

	@Override
	public void calcularStats(Personaje personaje, Guerrero guerrero) throws Exception{
		System.out.println("Soy guerrero humano");
		this.aumentarStatsSegunCasta(personaje, 10, 5, 0, 200, 0, 50);		
	}

	@Override
	public void calcularStats(Personaje personaje, Curandero curandero) throws Exception{
		System.out.println("Soy curandero humano");
		this.aumentarStatsSegunCasta(personaje, 0, 0, 15, 150, 200, 50);
	}

}
