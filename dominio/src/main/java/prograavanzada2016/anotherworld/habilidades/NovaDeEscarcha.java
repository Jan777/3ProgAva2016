package prograavanzada2016.anotherworld.habilidades;


import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.entities.Ente;

public class NovaDeEscarcha extends Habilidad{
	
	public NovaDeEscarcha() {
		this.id=2;
		this.costeMana=30;
		this.casta = new Mago();
		this.nivelRequerido=2;
	}
	@Override
	public void LanzarHechizo(Ente enteLanzador, Ente enteObjetivo) {
		if(enteLanzador.restarManaEnUso(this.costeMana)){
			enteObjetivo.serAtacadoConMagia(enteLanzador.getInteligencia()*3);
		}else{
			System.out.println("Fallo el lanzamiento");
		}		
	}
}
