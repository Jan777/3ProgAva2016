package prograavanzada2016.anotherworld.razas;

import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.entities.Personaje;

public interface ICalculaStats {
	public void calcularStats(Personaje personaje, Mago mago);
	public void calcularStats(Personaje personaje, Guerrero guerrero);
	public void calcularStats(Personaje personaje, Curandero curandero);
}
