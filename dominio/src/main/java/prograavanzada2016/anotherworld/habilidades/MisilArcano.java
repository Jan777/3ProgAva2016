package prograavanzada2016.anotherworld.habilidades;

import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.entities.Ente;

public class MisilArcano extends HabilidadPersonaje{
	
	public MisilArcano(){
		this.id=3;
		this.costeMana=5;
		this.casta = new Mago();
		this.nivelRequerido=1;
	}
	
	@Override
	public void LanzarHechizo(Ente enteLanzador, Ente enteObjetivo) {
		if(enteLanzador.restarManaEnUso(this.costeMana)){
			enteObjetivo.serAtacadoConMagia(enteLanzador.getInteligencia()*2);
		}else{
			System.out.println("Fallo el lanzamiento");
		}	
	}
	
}
