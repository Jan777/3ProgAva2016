package prograavanzada2016.anotherworld.combates;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Ente;
import prograavanzada2016.anotherworld.resources.GeneradorMagico;

public class Grupo {
	ArrayList<Ente> grupo = new ArrayList<>();

	public Grupo(ArrayList<Ente> grupo) {
		super();
		this.grupo = grupo;
	}

	public ArrayList<Ente> getGrupo() {
		return grupo;
	}

	public void setGrupo(ArrayList<Ente> grupo) {
		this.grupo = grupo;
	}
	
	public Ente seleccionarUnoAlAzar(){
		return this.grupo.get(GeneradorMagico.randInt(0, this.grupo.size()-1));
	}
	
	public boolean viven(){
		boolean flag=true;
		for(Ente ente: this.getGrupo()){
			if(ente.isEstaVivo()){
				flag=false;
			}
		}
		return flag;
	}
}
