package prograavanzada2016.anotherworld.mapas;

import prograavanzada2016.anotherworld.utilities.Recursos;

public class TileBush  extends Tile{
	public TileBush(int id) {
		super(Recursos.bush, id);
	}
	@Override
	public boolean esSolido() {
		return true;
	}
	
}
