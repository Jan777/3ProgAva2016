package prograavanzada2016.anotherworld.castas;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.enumvalues.TipoCasta;
import prograavanzada2016.anotherworld.razas.Raza;

public class Guerrero extends Casta{

	public Guerrero(TipoCasta tipoCasta) {
		super(tipoCasta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calcularStats(Personaje personaje, Raza raza) throws Exception{
		switch(raza.getTipoRaza()){
		case HUMANO:
			this.aumentarStatsSegunCasta(personaje, 5, 10, 0, 100, 0, 100);
		break;
		case ORCO:
			this.aumentarStatsSegunCasta(personaje, 10, 5, 0, 200, 0, 50);				
		break;
		default:
		throw new Exception("Error del sistema, se intento operar sobre una casta inexistente");
		}		
	}

}
