package prograavanzada2016.anotherworld.mapas;

import prograavanzada2016.anotherworld.NPCs.Dragon;
import prograavanzada2016.anotherworld.resources.GeneradorMagico;

public class MapaNivelUno extends Mapa{
	public MapaNivelUno() {
		this.larcho = 400;
		this.ancho = 400;
		this.zona1 = new CiudadBallena("Ciudad-Ballena", 200, 200, true);
		this.zona2 = new ZonaBosqueOscuro("Bosque-Oscuro-A",200,200,false);
		this.zona3 = new ZonaBosqueOscuro("Bosque-Oscuro-B",200,200,false);
		this.zona4 = new ZonaBosqueOscuro("Bosque-Oscuro-C",200,200,false);
		this.armarMapa();
		this.spawnearEnemigos();
	}

	@Override
	protected void spawnearEnemigos() {
		this.zona2.spawnear(new Dragon("dragon-menor", 1, 100, 100, 100, 5, 5, 5, false, 100, this,GeneradorMagico.randInt(this.zona2.getAnchoMinimo(), this.zona2.getAnchoMaximo()),GeneradorMagico.randInt(this.zona2.getLargoMinimo(), this.zona2.getLargoMaximo())));
		this.zona3.spawnear(new Dragon("dragon-medio", 10, 100, 100, 100, 5, 5, 5, false, 100, this,GeneradorMagico.randInt(this.zona3.getAnchoMinimo(), this.zona3.getAnchoMaximo()),GeneradorMagico.randInt(this.zona3.getLargoMinimo(), this.zona3.getLargoMaximo())));
		this.zona4.spawnear(new Dragon("dragon-mayor", 20, 100, 100, 100, 5, 5, 5, false, 100, this,GeneradorMagico.randInt(this.zona4.getAnchoMinimo(), this.zona4.getAnchoMaximo()),GeneradorMagico.randInt(this.zona4.getLargoMinimo(), this.zona4.getLargoMaximo())));
	}
}
