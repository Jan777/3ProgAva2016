package prograavanzada2016.anotherworld.combates;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Enemigo;
import prograavanzada2016.anotherworld.entities.Ente;
import prograavanzada2016.anotherworld.entities.Personaje;

public class ArenaPvP {
	private GrupoPersonajes grupoPersonajesA;
	private GrupoPersonajes grupoPersonajesB;
	private ArrayList<Float> listoPersonajesA;
	private ArrayList<Float> listoPersonajesB;
	
	public ArenaPvP(GrupoPersonajes grupoPersonajesA, GrupoPersonajes grupoPersonajesB) {
		this.grupoPersonajesA = grupoPersonajesA;
		this.grupoPersonajesB = grupoPersonajesB;
		listoPersonajesA=new ArrayList<>();
		listoPersonajesB=new ArrayList<>();
	}	
	
	public GrupoPersonajes getGrupoPersonajesA() {
		return grupoPersonajesA;
	}

	public void setGrupoPersonajesA(GrupoPersonajes grupoPersonajesA) {
		this.grupoPersonajesA = grupoPersonajesA;
	}

	public GrupoPersonajes getGrupoPersonajesB() {
		return grupoPersonajesB;
	}

	public void setGrupoPersonajesB(GrupoPersonajes grupoPersonajesB) {
		this.grupoPersonajesB = grupoPersonajesB;
	}

	public ArrayList<Float> getListoPersonajesA() {
		return listoPersonajesA;
	}

	public void setListoPersonajesA(ArrayList<Float> listoPersonajesA) {
		this.listoPersonajesA = listoPersonajesA;
	}

	public ArrayList<Float> getListoPersonajesB() {
		return listoPersonajesB;
	}

	public void setListoPersonajesB(ArrayList<Float> listoPersonajesB) {
		this.listoPersonajesB = listoPersonajesB;
	}

	public void armarTurnos(){
		int contadorDeAtaquesPersonajes=0;
		int contadorDeAtaquesEnemigos=0;
		for(int x=0; x<100000 && this.grupoPersonajesA.viven() && this.grupoPersonajesB.viven();x++){
			System.out.println("**************************");
			if(x%2==0){
				//turno aliados
				boolean flag=true;
				Ente enteConTurno = null;
				while(flag){
					Ente enteElegido = this.getGrupoPersonajesA().seleccionarUnoAlAzar();
					flag=this.yaAtacoPersonajeA(enteElegido);
					enteConTurno=enteElegido;
				}
				//Aca iria el turno del personaje por ahora es todo automatico
				enteConTurno.atacar(this.getGrupoPersonajesB().seleccionarUnoAlAzar());
				contadorDeAtaquesPersonajes+=1;
				if(contadorDeAtaquesPersonajes==this.getGrupoPersonajesA().getGrupo().size()){
					this.resetearTurnosPersonajesA();
				}
			}else{
				//turno enemigos
				boolean flag=true;
				Ente enteConTurno = null;
				while(flag){
					Ente enteElegido = this.getGrupoPersonajesB().seleccionarUnoAlAzar();
					flag=this.yaAtacoPersonajeB(enteElegido);
					enteConTurno=enteElegido;
				}
				//Aca iria el turno del personaje por ahora es todo automatico
				enteConTurno.atacar(this.getGrupoPersonajesA().seleccionarUnoAlAzar());
				contadorDeAtaquesEnemigos+=1;
				if(contadorDeAtaquesEnemigos==this.getGrupoPersonajesB().getGrupo().size()){
					this.resetearTurnosPersonajesB();
				}
			}
			
			if(!this.grupoPersonajesA.viven()){
				System.out.println("ganan izquierda");
				this.armarHistorial(grupoPersonajesB,grupoPersonajesA);
			}
			if(!this.grupoPersonajesB.viven()) {
				System.out.println("ganan derecha");
				this.armarHistorial(grupoPersonajesA,grupoPersonajesB);
			}
		}
	}


		private boolean yaAtacoPersonajeA(Ente ente) {
			boolean flag=false;
			for(Float id: this.getListoPersonajesA()){
				if(id.equals(ente.getIdEnte())){
					flag=true;
				}
			}
			if(!flag){
				this.getListoPersonajesA().add(ente.getIdEnte());
			}
			return flag;
		}
		
		private boolean yaAtacoPersonajeB(Ente ente) {
			boolean flag=false;
			for(Float id: this.getListoPersonajesB()){
				if(id.equals(ente.getIdEnte())){
					flag=true;
				}
			}
			if(!flag){
				this.getListoPersonajesB().add(ente.getIdEnte());
			}
			return flag;
		}
		
		private void resetearTurnosPersonajesA(){
			this.setListoPersonajesA(new ArrayList<>());
		}
		private void resetearTurnosPersonajesB(){
			this.setListoPersonajesB(new ArrayList<>());
		}
		
		private void armarHistorial(GrupoPersonajes ganadores, GrupoPersonajes perdedores){
			for(Personaje personaje : ganadores.getGrupo()){
				personaje.setHistorialDeVictorias(personaje.getHistorialDeVictorias()+1);
			}
			for(Personaje personaje : perdedores.getGrupo()){
				personaje.setHistorialDeDerrotas(personaje.getHistorialDeDerrotas()+1);
			}
		}
	}

