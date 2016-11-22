package prograavanzada2016.anotherworld.mapas;

import prograavanzada2016.anotherworld.utilities.Recursos;

public class TileLago1 extends Tile {
	public TileLago1(int id) {
		super(Recursos.lago1, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
