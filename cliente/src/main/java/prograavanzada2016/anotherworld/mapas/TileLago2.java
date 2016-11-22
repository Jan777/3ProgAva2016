package prograavanzada2016.anotherworld.mapas;

import prograavanzada2016.anotherworld.utilities.Recursos;

public class TileLago2 extends Tile {
	public TileLago2(int id) {
		super(Recursos.lago2, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
