package prograavanzada2016.anotherworld.habilidades;

import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.entities.Ente;

public class BolaDeFuego extends Habilidad{
	
	public BolaDeFuego(){
		this.id=1;
		this.costeMana=50;
		this.casta = new Mago();
		this.nivelRequerido=5;
	}
 
	@Override
	public void LanzarHechizo(Ente enteLanzador, Ente enteObjetivo) {
		if(enteLanzador.restarManaEnUso(this.costeMana)){
			enteObjetivo.serAtacadoConMagia(enteLanzador.getInteligencia()*5);
		}else{
			System.out.println("Fallo el lanzamiento");
		}	
	}

}
