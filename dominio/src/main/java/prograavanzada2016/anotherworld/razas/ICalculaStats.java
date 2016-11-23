package prograavanzada2016.anotherworld.razas;

import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.entities.Personaje;

public interface ICalculaStats {
	public void calcularStats(Personaje personaje, Mago mago) throws Exception;
	public void calcularStats(Personaje personaje, Guerrero guerrero) throws Exception;
	public void calcularStats(Personaje personaje, Curandero curandero) throws Exception;
}
