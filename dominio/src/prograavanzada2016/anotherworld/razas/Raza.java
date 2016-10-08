package prograavanzada2016.anotherworld.razas;

import prograavanzada2016.anotherworld.enumvalues.TipoRaza;

public abstract class Raza {
	
	protected TipoRaza tipoRaza;
	
	public Raza(TipoRaza tipoRaza){
		this.tipoRaza = tipoRaza;
	}

	public TipoRaza getTipoRaza() {
		return tipoRaza;
	}

	public void setTipoRaza(TipoRaza tipoRaza) {
		this.tipoRaza = tipoRaza;
	}	
}
