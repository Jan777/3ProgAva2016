package prograavanzada2016.anotherworld.combates;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Enemigo;
import prograavanzada2016.anotherworld.entities.Ente;
import prograavanzada2016.anotherworld.resources.GeneradorMagico;

public class GrupoEnemigos {

	ArrayList<Enemigo> grupo = new ArrayList<>();

	public GrupoEnemigos(ArrayList<Enemigo> grupo) throws Exception{
		super();
		this.grupo = grupo;
	}

	public ArrayList<Enemigo> getGrupo() {
		return grupo;
	}

	public void setGrupo(ArrayList<Enemigo> grupo) {
		this.grupo = grupo;
	}
	
	public Ente seleccionarUnoAlAzar() throws Exception{
		return this.grupo.get(GeneradorMagico.randInt(0, this.grupo.size()-1));
	}
	
	public boolean viven() throws Exception{
		boolean flag=true;
		for(Enemigo enemigo: this.getGrupo()){
			if(!enemigo.isEstaVivo()){
				flag=false;
			}
		}
		return flag;
	}

}
