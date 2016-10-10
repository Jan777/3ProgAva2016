package prograavanzada2016.anotherworld.entities;

import prograavanzada2016.anotherworld.enumvalues.Orientacion;
import prograavanzada2016.anotherworld.habilidades.Habilidad;

public abstract class Ente {
	
	//atributos principales de un Ente
	protected String nombre;
	protected int nivel;
	
	//atributos de stats de un Ente
	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected int salud;
	protected int mana;
	protected int energia;
	
	//atributos de ataque y defensa
	protected int ataque;
	protected int defensa;
	protected int puntosDeEnergiaPorAtaque;
	
	
	//atributos de ubicacion en el mapa de un Ente
	protected int posicionX;
	protected int posicionY;
	//este atributo indica hacia donde esta mirando el personaje
	protected Orientacion orientacion;
	
	//atributos de batalla de un ente
	protected boolean estaVivo;
	
	public Ente(String nombre){
		this.nombre = nombre;
		//inicializo los stats, a la hora de la creacion todos tienen el mismo stat base
		//luego con la seleccion de la casta estos stats son alterados
		//lo mismo pasara con la creacion de enemigos
		this.fuerza=this.destreza=this.inteligencia=5;
		this.salud=this.mana=this.energia=100;
		this.ataque=10;
		this.defensa=0;
		this.puntosDeEnergiaPorAtaque=100;
		this.nivel=1;
	}
	
	protected Ente (String nombre, int nivel, int salud, int energia, int mana, int fuerza, int destreza, int inteligencia)
	{
		this.nombre = nombre;
		this.nivel = nivel;
		this.salud = salud;
		this.energia = energia;
		this.mana = mana;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
	}
		
	public int getNivel() {
		return nivel;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void aumentarFuerza(int fuerza) {
		this.fuerza += fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public void aumentarDestreza(int destreza) {
		this.destreza += destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void aumentarInteligencia(int inteligencia) {
		this.inteligencia += inteligencia;
	}

	public int getSalud() {
		return salud;
	}

	public void aumentarSalud(int salud) {
		this.salud += salud;
	}

	public void restarSalud(int salud){
		this.salud -= salud;
		if(this.salud<=0){
			this.estaVivo=false;
		}
	}
	
	public int getMana() {
		return mana;
	}

	public void aumentarMana(int mana) {
		this.mana += mana;
	}
	
	public void restarMana(int mana){
		this.mana -= mana;
	}

	public int getEnergia() {
		return energia;
	}

	public void aumentarEnergia(int energia) {
		this.energia += energia;
	}
	
	public void restarEnergia(int energia){
		this.energia -= energia;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	
	
	public Orientacion getOrientacion() {
		return orientacion;
	}


	public void setOrientacion(Orientacion orientacion) {
		this.orientacion = orientacion;
	}
	
	
	

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	//una primera idea del metodo, seguramente hay que modificarlo cuando
	//tengamos mas idea de como es el movimiento
	public void moverse(int posicionX, int posicionY){
		this.posicionX+=posicionX;
		this.posicionY+=posicionY;
		//calculo de la orientacion aun no tengo idea de como se hace
		this.setOrientacion(Orientacion.ESTE);
	}
	
	//una primera idea del metodo
	public void atacar(Ente ente){
		if(this.puedeAtacar()){
			ente.serAtacado(this.calcularPuntosDeAtaque());
			ente.despuesDeAtacar();
		}else{
			System.out.println("Intento atacar pero fallo");
		}
	}
	
	public boolean puedeAtacar(){
		this.restarEnergia(this.puntosDeEnergiaPorAtaque);
		if(this.getEnergia()>0){
			return true;
		}
		return false;
	}
	
	public abstract void serAtacado(int daño);
	
	public abstract int calcularPuntosDeAtaque();
	//pienso manejar este evento creando una Entidad Evento
	//en la cual en un combate se vaya creando una pila de Evento
	//y luego despues del ataque se llame a esa pila y haga lo que tenga que hacer
	//hay que debatir este metodo
	public abstract void despuesDeAtacar();
	
	public abstract void serHechizado(Habilidad habilidad);
}
