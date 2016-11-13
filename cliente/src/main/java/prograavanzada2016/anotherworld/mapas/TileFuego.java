package prograavanzada2016.anotherworld.mapas;

import prograavanzada2016.anotherworld.utilities.*;

public class TileFuego extends Tile {
	
	public TileFuego(int id) {
		super(Recursos.piso, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
