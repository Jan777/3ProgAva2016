package prograavanzada2016.anotherworld.mapas;

import prograavanzada2016.anotherworld.utilities.Recursos;

public class TileFuego2 extends Tile{
	public TileFuego2(int id) {
		super(Recursos.piso2, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
