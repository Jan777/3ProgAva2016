package prograavanzada2016.anotherworld.castas;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.enumvalues.TipoCasta;
import prograavanzada2016.anotherworld.enumvalues.TipoRaza;
import prograavanzada2016.anotherworld.razas.Raza;

public class Mago extends Casta{

	public Mago(TipoCasta tipoCasta) {
		super(tipoCasta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calcularStats(Personaje personaje, Raza raza) throws Exception {
		switch(raza.getTipoRaza()){
			case HUMANO:
				this.aumentarStatsSegunCasta(personaje, 0, 10, 3, 50, 200, 50);
			break;
			case ORCO:
				this.aumentarStatsSegunCasta(personaje, 0, 5, 3, 150, 100, 50);			
			break;
			default:
			throw new Exception("Error del sistema, se intento operar sobre una casta inexistente");
		}		
	}

}
