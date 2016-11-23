package prograavanzada2016.anotherworld.combates;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Ente;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.resources.GeneradorMagico;

public class GrupoPersonajes {
	ArrayList<Personaje> grupo = new ArrayList<>();

	public GrupoPersonajes(ArrayList<Personaje> grupo) throws Exception {
		super();
		this.grupo = grupo;
	}

	public ArrayList<Personaje> getGrupo() {
		return grupo;
	}

	public void setGrupo(ArrayList<Personaje> grupo) {
		this.grupo = grupo;
	}
	
	public void setGrupo(Alianza alianza) {
		
	}
	
	public Ente seleccionarUnoAlAzar() throws Exception{
		return this.grupo.get(GeneradorMagico.randInt(0, this.grupo.size()-1));
	}
	
	public boolean viven() throws Exception{
		boolean flag=true;
		for(Personaje personaje: this.getGrupo()){
			if(!personaje.isEstaVivo()){
				flag=false;
			}
		}
		return flag;
	}
}
