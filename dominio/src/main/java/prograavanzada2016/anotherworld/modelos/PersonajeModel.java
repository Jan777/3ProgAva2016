package prograavanzada2016.anotherworld.modelos;

public class PersonajeModel {
	private int id;
	private int usuarioId;
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
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
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
}
