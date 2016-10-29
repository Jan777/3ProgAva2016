package prograavanzada2016.anotherworld.combates;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Ente;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.resources.GeneradorMagico;

public class ArenaPvE {
	private Grupo grupoEnemigos;
	private Grupo grupoPersonajes;
	private int cantidadDeExperiencia;
	private ArrayList<Float> listoPersonajes;
	private ArrayList<Float> listoEnemigos;
	private Loot loot;
	private boolean gananLosPersonajes;
	
	public ArenaPvE(Grupo grupoEnemigos, Grupo grupoPersonajes) {
		this.grupoEnemigos = grupoEnemigos;
		this.grupoPersonajes = grupoPersonajes;
		this.loot = new Loot();
	}


	public Grupo getGrupoEnemigos() {
		return grupoEnemigos;
	}


	public void setGrupoEnemigos(Grupo grupoEnemigos) {
		this.grupoEnemigos = grupoEnemigos;
	}


	public Grupo getGrupoPersonajes() {
		return grupoPersonajes;
	}


	public void setGrupoPersonajes(Grupo grupoPersonajes) {
		this.grupoPersonajes = grupoPersonajes;
	}


	public int getCantidadDeExperiencia() {
		return cantidadDeExperiencia;
	}


	public void setCantidadDeExperiencia(int cantidadDeExperiencia) {
		this.cantidadDeExperiencia = cantidadDeExperiencia;
	}
	
	
	public ArrayList<Float> getListoPersonajes() {
		return listoPersonajes;
	}


	public void setListoPersonajes(ArrayList<Float> listoPersonajes) {
		this.listoPersonajes = listoPersonajes;
	}


	public ArrayList<Float> getListoEnemigos() {
		return listoEnemigos;
	}


	public void setListoEnemigos(ArrayList<Float> listoEnemigos) {
		this.listoEnemigos = listoEnemigos;
	}
	
	public boolean isGananLosPersonajes() {
		return gananLosPersonajes;
	}


	public void setGananLosPersonajes(boolean gananLosPersonajes) {
		this.gananLosPersonajes = gananLosPersonajes;
	}

	private void armarTurnos(){
		int contadorDeAtaquesPersonajes=0;
		int contadorDeAtaquesEnemigos=0;
		for(int x=0; x<100000 && this.grupoEnemigos.viven() && this.grupoPersonajes.viven();x++){
			if(x%2==0){
				//turno aliados
				boolean flag=true;
				Ente enteConTurno = null;
				while(flag){
					Ente enteElegido = this.getGrupoPersonajes().seleccionarUnoAlAzar();
					flag=this.yaAtacoPersnaje(enteElegido);
					enteConTurno=enteElegido;
				}
				//Aca iria el turno del personaje por ahora es todo automatico
				enteConTurno.atacar(this.getGrupoEnemigos().seleccionarUnoAlAzar());
				contadorDeAtaquesPersonajes+=1;
				if(contadorDeAtaquesPersonajes==this.getGrupoPersonajes().getGrupo().size()){
					this.resetearTurnosPersonajes();
				}
			}else{
				//turno enemigos
				boolean flag=true;
				Ente enteConTurno = null;
				while(flag){
					Ente enteElegido = this.getGrupoPersonajes().seleccionarUnoAlAzar();
					flag=this.yaAtacoPersnaje(enteElegido);
					enteConTurno=enteElegido;
				}
				//Aca iria el turno del personaje por ahora es todo automatico
				enteConTurno.atacar(this.getGrupoPersonajes().seleccionarUnoAlAzar());
				contadorDeAtaquesEnemigos+=1;
				if(contadorDeAtaquesEnemigos==this.getGrupoEnemigos().getGrupo().size()){
					this.resetearTurnosEnemigos();
				}
			}
			
			if(this.grupoEnemigos.viven()){
				System.out.println("Murieron todos los Enemigos");
			}
			if(this.grupoPersonajes.viven()) {
				System.out.println("Murieron todos los Personajes");
			}
		}
	}


	private boolean yaAtacoPersnaje(Ente ente) {
		boolean flag=false;
		for(Float id: this.getListoPersonajes()){
			if(id.equals(ente.getIdEnte())){
				flag=true;
			}
		}
		if(!flag){
			this.getListoPersonajes().add(ente.getIdEnte());
		}
		return flag;
	}
	
	private boolean yaAtacoEnemigo(Ente ente) {
		boolean flag=false;
		for(Float id: this.getListoEnemigos()){
			if(id.equals(ente.getIdEnte())){
				flag=true;
			}
		}
		if(!flag){
			this.getListoEnemigos().add(ente.getIdEnte());
		}
		return flag;
	}
	
	private void resetearTurnosEnemigos(){
		this.setListoEnemigos(new ArrayList<>());
	}
	
	private void resetearTurnosPersonajes(){
		this.setListoPersonajes(new ArrayList<>());
	}
	
	
}
