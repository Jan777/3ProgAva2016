package prograavanzada2016.anotherworld.entities;

import prograavanzada2016.anotherworld.combates.Loot;
import prograavanzada2016.anotherworld.enumvalues.Orientacion;
import prograavanzada2016.anotherworld.habilidades.HabilidadPersonaje;
import prograavanzada2016.anotherworld.mapas.Mapa;
import prograavanzada2016.anotherworld.mapas.Zona;

public abstract class Ente {
	//nos va a ayudar a indentifcar al momento de las Arenas para saber si ataco o no
	protected float idEnte;
	
	//atributos principales de un Ente
	protected String nombre;
	protected int nivel;
	
	//atributos de stats de un Ente
	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected int salud;
	protected int saludEnUso;
	protected int mana;
	protected int manaEnUso;
	protected int energia;
	protected int energiaEnUso;
	
	//puntos que le podrá añadir a los stats cuando sube de nivel
	protected int puntosAdicionalesALosStats;
	
	//atributos de ataque y defensa
	protected int ataque;
	protected int defensa;
	protected int puntosDeEnergiaPorAtaque;
	
	
	//atributos de ubicacion en el mapa de un Ente
	protected int posicionX;
	protected int posicionY;
	protected Mapa mapa;
	protected Zona zona;
	protected Orientacion orientacion;
	
	//atributos de batalla de un ente
	protected boolean estaVivo;
	protected boolean estaEnBatalla;
	
	public Ente(){
		
	}
	
	public Ente(String nombre){
		this.nombre = nombre;
		this.setEstaVivo(true);
		//inicializo los stats, a la hora de la creacion todos tienen el mismo stat base
		//luego con la seleccion de la casta estos stats son alterados
		//lo mismo pasara con la creacion de enemigos
		this.fuerza=this.destreza=this.inteligencia=5;
		this.salud=this.mana=this.energia=100;
		this.ataque=5;
		this.defensa=0;
		this.puntosDeEnergiaPorAtaque=10;
		this.nivel=1;
		this.posicionX=this.posicionY=0;
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
	
	protected Ente (long id, String nombre, int nivel, int salud, int energia, int mana, int fuerza, int destreza, int inteligencia)
	{
		this.idEnte = id;
		this.nombre = nombre;
		this.nivel = nivel;
		this.salud = salud;
		this.energia = energia;
		this.mana = mana;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
	}
	
	
	public float getIdEnte() {
		return idEnte;
	}

	public void setIdEnte(float idEnte) {
		this.idEnte = idEnte;
	}
	
	
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
	public int getNivel() {
		return nivel;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void aumentarFuerza(int fuerza) {
		if(fuerza <= puntosAdicionalesALosStats)
		{
			this.fuerza += fuerza;
			puntosAdicionalesALosStats-=fuerza;
		}else if(nivel == 1)
		{
			this.fuerza += fuerza;
		}
	}

	public int getDestreza() {
		return destreza;
	}

	public void aumentarDestreza(int destreza) {
		if(destreza <= puntosAdicionalesALosStats)
		{
			this.destreza += destreza;
			puntosAdicionalesALosStats-=destreza;
		}else if(nivel == 1)
		{
			this.destreza += destreza;
		}
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void aumentarInteligencia(int inteligencia) {
		if(inteligencia <= puntosAdicionalesALosStats)
		{
			this.inteligencia += inteligencia;
			puntosAdicionalesALosStats-=inteligencia;
		}else if(nivel == 1)
		{
			this.inteligencia += inteligencia;
		}
	}

	public int getSalud() {
		return salud;
	}

	public void aumentarSalud(int salud) {
		this.salud = salud;
		this.saludEnUso = salud;
	}
		
	public int getSaludEnUso() {
		return saludEnUso;
	}
	
	public void aumentarSaludEnUso(int saludEnUso) {
		this.saludEnUso += saludEnUso;
		if(this.saludEnUso>this.salud){
			this.saludEnUso=salud;
		}
	}

	public void restarSaludEnUso(int saludEnUso) {
		this.saludEnUso -= saludEnUso;
		if(this.saludEnUso<=0){
			this.saludEnUso=0;
			this.estaVivo=false;
			this.despuesDeMorir();
		}
	}
	
	public abstract void despuesDeMorir();
	
	public int getMana() {
		return mana;
	}

	public void aumentarMana(int mana) {
		this.mana += mana;
		this.manaEnUso=this.mana;
	}
	
	public int getManaEnUso() {
		return manaEnUso;
	}
	
	public void setManaEnUso(int manaEnUso) {
		this.manaEnUso = manaEnUso;
	}
	
	public boolean restarManaEnUso(int manaEnUso) {
		if(this.manaEnUso>=manaEnUso){
			this.manaEnUso -= manaEnUso;
			return true;
		}
		return false;
	}

	public int getEnergia() {
		return energia;
	}

	public void aumentarEnergia(int energia) {
		this.energia += energia;
		this.energiaEnUso=this.energia;
	}
	
	
	public int getEnergiaEnUso() {
		return energiaEnUso;
	}

	public void setEnergiaEnUso(int energiaEnUso) {
		this.energiaEnUso = energiaEnUso;
	}

	public boolean restarEnergiaEnUso(int energia){
		if(this.energiaEnUso>=energia){
			this.energiaEnUso -= energia;
			return true;
		}
		return false;
	}
	
	public void descansar(){
		this.energiaEnUso += this.getEnergia()*10/100;
		if(this.energia<this.energiaEnUso){
			this.energiaEnUso=this.energia;
		}
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

	public boolean isEstaVivo() {
		return estaVivo;
	}

	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
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
	
	
	public int getPuntosDeEnergiaPorAtaque() {
		return puntosDeEnergiaPorAtaque;
	}

	public void setPuntosDeEnergiaPorAtaque(int puntosDeEnergiaPorAtaque) {
		this.puntosDeEnergiaPorAtaque = puntosDeEnergiaPorAtaque;
	}
	
	
	
	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
		
	public Zona getZona() throws Exception {
		return this.getMapa().getZonaByEnte(this);
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	//una primera idea del metodo, seguramente hay que modificarlo cuando
	//tengamos mas idea de como es el movimiento
	public void moverse(int posicionX, int posicionY){
		this.posicionX=posicionX;
		this.posicionY=posicionY;
		//calculo de la orientacion aun no tengo idea de como se hace
		this.setOrientacion(Orientacion.ESTE);
	}
	
	//una primera idea del metodo
	public void atacar(Ente ente){
		if(ente.isEstaVivo()){
			if(this.puedeAtacar()){
				ente.serAtacado(this.calcularPuntosDeAtaque());
				//ente.despuesDeAtacar();
			}else{
				System.out.println("Intento atacar pero fallo");
			}
		}else{
			System.out.println("Aguanta He-Man, ya estoy muerto");
		}
		this.despuesDeAtacar(ente);
	}
	
	public boolean puedeAtacar(){
		if(this.restarEnergiaEnUso(this.puntosDeEnergiaPorAtaque)){
			return true;
		}
		return false;
	}
	
	public abstract void serAtacado(int daño);
	public abstract void serAtacadoConMagia(int daño);
	
	public abstract int calcularPuntosDeAtaque();
	//pienso manejar este evento creando una Entidad Evento
	//en la cual en un combate se vaya creando una pila de Evento
	//y luego despues del ataque se llame a esa pila y haga lo que tenga que hacer
	//hay que debatir este metodo
	public abstract void despuesDeAtacar(Ente ente);
	
	public abstract void serHechizado(HabilidadPersonaje habilidad);
	
	public boolean puedeEntrarEnCombate(Ente ente) throws Exception{
		//si la zona no es neutral y al menos estan en la misma zona puede atacar
		return ente.getZona().equals(this.getZona())&&
				this.getMapa().getZonaByEnte(this).isNeutral();
	}
	
	public abstract void dropearObjetos(Loot loot);
	
	public boolean colisiona(){
		return false;
	}
	
}
