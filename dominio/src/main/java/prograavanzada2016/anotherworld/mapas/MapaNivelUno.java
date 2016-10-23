package prograavanzada2016.anotherworld.mapas;

import java.util.ArrayList;

public class MapaNivelUno extends Mapa{
	public MapaNivelUno() {
		this.larcho = 400;
		this.ancho = 400;
		this.zona1 = new CiudadBallena("Ciudad-Ballena", 200, 200, true);
		this.zona2 = new ZonaBosqueOscuro("Bosque-Oscuro-A",200,200,false);
		this.zona3 = new ZonaBosqueOscuro("Bosque-Oscuro-B",200,200,false);
		this.zona4 = new ZonaBosqueOscuro("Bosque-Oscuro-C",200,200,false);
	}
}
