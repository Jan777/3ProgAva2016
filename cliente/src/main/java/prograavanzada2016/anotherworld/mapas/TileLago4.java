package prograavanzada2016.anotherworld.mapas;

import prograavanzada2016.anotherworld.utilities.Recursos;

public class TileLago4 extends Tile {
	public TileLago4(int id) {
		super(Recursos.lago4, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
