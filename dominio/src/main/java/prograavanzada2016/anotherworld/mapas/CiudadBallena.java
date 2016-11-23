package prograavanzada2016.anotherworld.mapas;

import java.util.ArrayList;

public class CiudadBallena extends Zona{

	public CiudadBallena(String nombre, int largo, int ancho, boolean neutral) throws Exception{
		this.nombre = nombre;
		this.largo = largo;
		this.ancho = ancho;
		this.neutral = true;
		this.enemigos= new ArrayList<>();
	}

}
