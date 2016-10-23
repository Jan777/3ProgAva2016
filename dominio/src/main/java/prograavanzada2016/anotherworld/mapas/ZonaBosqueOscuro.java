package prograavanzada2016.anotherworld.mapas;

import java.util.ArrayList;

public class ZonaBosqueOscuro extends Zona{
	public ZonaBosqueOscuro(String nombre, int largo, int ancho, boolean neutral) {
		this.nombre = nombre;
		this.largo = largo;
		this.ancho = ancho;
		this.neutral = true;
		this.enemigos = new ArrayList<>();
	}
}
