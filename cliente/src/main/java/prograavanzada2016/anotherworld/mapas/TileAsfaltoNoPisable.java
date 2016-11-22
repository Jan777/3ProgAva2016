package prograavanzada2016.anotherworld.mapas;

import prograavanzada2016.anotherworld.utilities.Recursos;

public class TileAsfaltoNoPisable extends Tile {
	public TileAsfaltoNoPisable(int id) {
		super(Recursos.asfalto, id);
	}
	@Override
	public boolean esSolido() {
		return true;
	}
}
