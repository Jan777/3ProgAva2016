package prograavanzada2016.anotherworld.modelos;

import prograavanzada2016.anotherworld.entities.Personaje;

public class PersonajeModel {
	private int id;
	private long usuarioId;
	private int castaId;
	private int razaId;
	private String nombre;
	private int fuerza;
	private int destreza;
	private int inteligencia;
	private int mana;
	private int energia;
	private int nivel;
	private int salud;
	private int experiencia;
	
	private int posicionInicialX;
	private int posicionInicialY;
	
	//movimientos
	private int movimientoX;
	private int movimientoY;
	private int movimientoOffsetX;
	private int movimientoOffsetY;
	private int movimientoXFinal;
	private int movimientoYFinal;
	
	private boolean nuevoCamino;
	
	
	private String raza;
	private String casta;
	public PersonajeModel(int id, int usuarioId, int castaId, int razaId, String nombre, int fuerza, int destreza,
			int inteligencia, int mana, int energia, int nivel, int salud, int experiencia) {
		this.id = id;
		this.usuarioId = usuarioId;
		this.castaId = castaId;
		this.razaId = razaId;
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.mana = mana;
		this.energia = energia;
		this.nivel = nivel;
		this.salud = salud;
		this.experiencia = experiencia;
		
		this.casta= this.obtenerCastaString(castaId);
		this.raza = this.obtenerRazaString(razaId);
	}

	public PersonajeModel(String nombre, String casta, String raza,long usuarioId) throws Exception {
		this.nombre=nombre;
		this.castaId=this.obtenerCasta(casta);
		this.razaId=this.obtenerRaza(raza);
		this.usuarioId=usuarioId;
		this.casta=casta;
		this.raza=raza;
		Personaje p = new Personaje(this.nombre,this.razaId,this.castaId);
		PersonajeModel pBase = p.obtenerModelo();
		this.setFuerza(pBase.getFuerza());
		this.setInteligencia(pBase.getInteligencia());
		this.setDestreza(pBase.getDestreza());
		this.setEnergia(pBase.getEnergia());
		this.setMana(pBase.getMana());
		this.setNivel(pBase.getNivel());
		this.setSalud(pBase.getSalud());
	}
	public PersonajeModel() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCastaId() {
		return castaId;
	}
	public void setCastaId(int castaId) {
		this.castaId = castaId;
	}
	public int getRazaId() {
		return razaId;
	}
	public void setRazaId(int razaId) {
		this.razaId = razaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFuerza() {
		return fuerza;
	}
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	public int getDestreza() {
		return destreza;
	}
	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}
	public int getInteligencia() {
		return inteligencia;
	}
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getSalud() {
		return salud;
	}
	public void setSalud(int salud) {
		this.salud = salud;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	public long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public String getRaza() {
		return this.obtenerRazaString(razaId);
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getCasta() {
		return this.obtenerCastaString(castaId);
	}
	public void setCasta(String casta) {
		this.casta = casta;
	}
	public int obtenerCasta(String casta){
		if(casta.equals("Guerrero")){
			return 1;
		}else if(casta.equals("Mago")){
			return 2;
		}
		return 3;
	}
	
	public int obtenerRaza(String raza){
		if(raza.equals("Humano")){
			return 1;
		}
		return 2;
	}
	
	private String obtenerRazaString(int razaId) {
		if(razaId==1){
			return "Humano";
		}
		return "Orco";
	}
	private String obtenerCastaString(int castaId) {
		if(castaId==1){
			return "Guerrero";
		}else if(castaId==2){
			return "Mago";
		}
		return "Curandero";
	}
	public int getMovimientoX() {
		return movimientoX;
	}
	public void setMovimientoX(int movimientoX) {
		this.movimientoX = movimientoX;
	}
	public int getMovimientoY() {
		return movimientoY;
	}
	public void setMovimientoY(int movimientoY) {
		this.movimientoY = movimientoY;
	}
	public boolean isNuevoCamino() {
		return nuevoCamino;
	}
	public void setNuevoCamino(boolean nuevoCamino) {
		this.nuevoCamino = nuevoCamino;
	}
	public int getMovimientoOffsetX() {
		return movimientoOffsetX;
	}
	public void setMovimientoOffsetX(int movimientoOffsetX) {
		this.movimientoOffsetX = movimientoOffsetX;
	}
	public int getMovimientoOffsetY() {
		return movimientoOffsetY;
	}
	public void setMovimientoOffsetY(int movimientoOffsetY) {
		this.movimientoOffsetY = movimientoOffsetY;
	}
	public int getMovimientoXFinal() {
		return movimientoXFinal;
	}
	public void setMovimientoXFinal(int movimientoXFinal) {
		this.movimientoXFinal = movimientoXFinal;
	}
	public int getMovimientoYFinal() {
		return movimientoYFinal;
	}
	public void setMovimientoYFinal(int movimientoYFinal) {
		this.movimientoYFinal = movimientoYFinal;
	}

	public int getPosicionInicialX() {
		return posicionInicialX;
	}

	public void setPosicionInicialX(int posicionInicialX) {
		this.posicionInicialX = posicionInicialX;
	}

	public int getPosicionInicialY() {
		return posicionInicialY;
	}

	public void setPosicionInicialY(int posicionInicialY) {
		this.posicionInicialY = posicionInicialY;
	}
}
