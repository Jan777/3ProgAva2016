package prograavanzada2016.anotherworld.habilidades;

import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.entities.Ente;

public class Curar extends HabilidadPersonaje{
	
	public Curar() throws Exception{
		this.id=3;
		this.costeMana=20;
		this.casta = new Curandero();
		this.nivelRequerido=2;
	}
	
	@Override
	public void LanzarHechizo(Ente enteLanzador, Ente enteObjetivo) {
		if(enteLanzador.restarManaEnUso(this.costeMana)){
			enteObjetivo.aumentarSaludEnUso(enteLanzador.getInteligencia()*3);
		}else{
			System.out.println("Fallo el lanzamiento");
		}		
	}

}
