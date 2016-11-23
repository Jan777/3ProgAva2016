package prograavanzada2016.anotherworld.habilidades;

import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.entities.Ente;

public class Rodillazo extends HabilidadPersonaje{
	public Rodillazo() throws Exception{
		this.costeMana=10;
		this.casta= new Guerrero();
		this.nivelRequerido=2;
	}

	@Override
	public void LanzarHechizo(Ente enteLanzador, Ente enteObjetivo) {
		if(enteLanzador.restarManaEnUso(this.costeMana)){
			enteObjetivo.serAtacadoConMagia(enteLanzador.getFuerza()*2);
		}else{
			System.out.println("Fallo el lanzamiento");
		}	
	}
	
}
