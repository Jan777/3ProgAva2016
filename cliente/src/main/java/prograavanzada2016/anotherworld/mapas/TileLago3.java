package prograavanzada2016.anotherworld.mapas;

import prograavanzada2016.anotherworld.utilities.Recursos;

public class TileLago3 extends Tile {
	public TileLago3(int id) {
		super(Recursos.lago3, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
