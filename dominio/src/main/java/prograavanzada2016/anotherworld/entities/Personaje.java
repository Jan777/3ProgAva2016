package prograavanzada2016.anotherworld.entities;

import prograavanzada2016.anotherworld.castas.Casta;
import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.combates.Alianza;
import prograavanzada2016.anotherworld.combates.Loot;
import prograavanzada2016.anotherworld.habilidades.HabilidadPersonaje;
import prograavanzada2016.anotherworld.modelos.PersonajeModel;
import prograavanzada2016.anotherworld.objetos.*;
import prograavanzada2016.anotherworld.razas.Humano;
import prograavanzada2016.anotherworld.razas.Orco;
import prograavanzada2016.anotherworld.razas.Raza;

public class Personaje extends Ente{
	
	//Atributos de la bdd
	protected int id;
	protected long usuarioId;
	protected int castaId;
	protected int razaId;
	protected String nombrePj;

	//Atributos jugables
	protected Casta casta;
	protected Raza raza;
	
	protected ObjetoArma objetoArma;
	protected ObjetoArmadura objetoArmadura;
	
	//experiencia que tiene el jugador en el momento
	protected int experienciaActual;
	//experiencia que necesita el jugador para subir de nivel
	protected int experienciaLimite;
	
	protected int historialDeVictorias;
	protected int historialDeDerrotas;
	
	protected Alianza alianza = null;
	
	public Personaje(){
		super();
	}
	
	public Personaje(String nombre, Raza raza, Casta casta) throws Exception {
		super(nombre);
		this.raza=raza;
		this.casta=casta;
		this.casta.calcularStats(this);
		this.casta.guardarHabilidades();
		this.puntosAdicionalesALosStats = 0;
		//cuando se crea un personaje se le debe modificar sus stats segun la raza
		//this.casta.calcularStats(this, raza);
	}
	
	public Personaje(String nombre, int razaId, int castaId) throws Exception{
		super(nombre);
		Raza raza;
		Casta casta;
		switch(razaId){
		case 1:
			raza = new Humano();
			break;
		case 2:
			raza = new Orco();
			break;
		default:
			raza = new Humano();
			break;
		}
		
		switch(castaId){
		case 1:
			casta = new Guerrero();
			break;
		case 2:
			casta = new Mago();
			break;
		case 3:
			casta = new Curandero();
		default:
			casta = new Curandero();
			break;
		}
		this.raza=raza;
		this.casta=casta;
		this.casta.calcularStats(this);
	}
	
	public Personaje(int id, String nombre, int fuerza, int salud, int destreza, int inteligencia, int mana, int energia, int nivel, int experiencia, int casta_id, int raza_id, int usuario_id){
		super(id,nombre,nivel,salud,energia,mana,fuerza,destreza,inteligencia);
		this.experienciaActual = experiencia;
		//this.id_casta
		//this.id_raza
		//this.usuario_id
	}

	public Personaje(PersonajeModel personaje) {
		this.setAtaque(personaje.getFuerza());
		this.setSalud(personaje.getSalud());
		this.setNombre(personaje.getNombre());
	}

	@Override
	public void serAtacado(int daño) {
		int dañoNeto = daño-this.defensa;
		if(dañoNeto>0){
			this.restarSaludEnUso(dañoNeto);
		}
	}
	
	@Override
	public void serAtacadoConMagia(int daño) {
		int dañoNeto = daño;
		if(dañoNeto>0){
			this.restarSaludEnUso(dañoNeto);
		}
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return this.ataque;
	}

	@Override
	public void despuesDeAtacar(Ente ente) {
		if(!ente.estaVivo)
		{
			this.sumarExperiencia(5);;
		}
	}

	@Override
	public void serHechizado(HabilidadPersonaje habilidad) {
		// TODO Auto-generated method stub
		
	}
	
	public int getExperienciaActual() {
		return experienciaActual;
	}
	
	public void subirNivel() {
		this.nivel = this.nivel+1;
		this.puntosAdicionalesALosStats += 5;
	}

	public void sumarExperiencia(int experiencia) {
		this.experienciaActual += experiencia;
		if(this.experienciaActual>=this.experienciaLimite){
			this.subirNivel();
			this.experienciaActual=0;
		}
	}
	
	public void equiparArma(ObjetoArma objetoArma){
		if(objetoArma.getCasta().equals(this.getCasta()) && objetoArma.getNivelMinimo()<=this.getNivel()){
			this.objetoArma=objetoArma;
			this.setAtaque(objetoArma.getBonusAtaque()+this.getAtaque());
			this.setPuntosDeEnergiaPorAtaque(objetoArma.getPuntosDeEnergiaPorAtaque());
		}else{
			//System.out.println("No se puede equipar el arma, reload reload");
		}
	}
	
	public void equiparArmadura(ObjetoArmadura objetoArmadura){
		if(objetoArmadura.getCasta().equals(this.getCasta()) && objetoArmadura.getNivelMinimo()<=this.getNivel()){
			this.objetoArmadura=objetoArmadura;
			this.setDefensa(objetoArmadura.getBonusDefensa()+this.getDefensa());
		}else{
			//System.out.println("Una fuerza extraña me impide usar esta armadura");
		}
	}
	
	public void lanzarHabilidad(int id,Ente enteObjetivo){
		HabilidadPersonaje habilidad = this.getCasta().getHabilidad(id);
		if(habilidad.getNivelRequerido()<=this.getNivel()){
			habilidad.LanzarHechizo(this, enteObjetivo);
		}else{
			//System.out.println("Siento que aun me falta energias para esta tecnica.");
		}
	}
	
	public int getExperienciaLimite() {
		return experienciaLimite;
	}

	public void setExperienciaLimite(int experienciaLimite) {
		this.experienciaLimite = experienciaLimite;
	}

	public Casta getCasta() {
		return casta;
	}

	public void setCasta(Casta casta) {
		this.casta = casta;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}
	
	
	
	public int getHistorialDeVictorias() {
		return historialDeVictorias;
	}

	public void setHistorialDeVictorias(int historialDeVictorias) {
		this.historialDeVictorias = historialDeVictorias;
	}

	public int getHistorialDeDerrotas() {
		return historialDeDerrotas;
	}

	public void setHistorialDeDerrotas(int historialDeDerrotas) {
		this.historialDeDerrotas = historialDeDerrotas;
	}

	public void mostrarStats(){
		/*System.out.println("Nombre: "+super.getNombre());
		System.out.println("Nivel: "+super.getNivel());
		System.out.println("Fuerza: "+this.getFuerza());
		System.out.println("Destreza: "+this.getDestreza());
		System.out.println("Inteligecia: "+this.getInteligencia());
		System.out.println("Salud: "+this.getSalud());
		System.out.println("Salud en uso: "+this.getSaludEnUso());
		System.out.println("Mana: "+this.getMana());
		System.out.println("Mana en uso: "+this.getManaEnUso());
		System.out.println("Energia: "+this.getEnergia());
		System.out.println("Energia en uso:"+this.energiaEnUso);*/
	}

	@Override
	public void dropearObjetos(Loot loot)
	{
		// Al morir, ¿dropea el mejor item?
	}
	
	public void crearAlianza(String nombreAlianza) throws Exception
	{
		abandonarAlianzaActual();
		this.alianza = new Alianza(nombreAlianza, this);
	}
	
	public void añadirPersonajeAlianza(Personaje p) throws Exception
	{
		// Checkear que el personaje a añadir no esté en la alianza.
		this.alianza.agregarMiembro(p);
		p.serAñadidoAlianza(this.alianza);
	}
	
	public void serAñadidoAlianza(Alianza a) throws Exception
	{
		// Consultar si quiere aceptar.
		this.abandonarAlianzaActual();
		this.alianza = a;
	}
	
	public void abandonarAlianzaActual() throws Exception
	{
		if (this.alianza != null)
		{
			this.alianza.quitarMiembro(this);
			this.alianza = null;
		}
	}
	
	public String getNombreAlianza()
	{
		return (this.alianza != null) ? this.alianza.getNombre() : "";
	}
	
	public int getCantMienbrosAlianza()
	{
		return (this.alianza != null) ? this.alianza.getCantMiembros() : 0;
	}
	
	public float getBonusExp()
	{
		return (this.alianza != null) ? this.alianza.getBonusExp() : 1;
	}

	@Override
	public void despuesDeMorir() {
		// TODO Auto-generated method stub
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public PersonajeModel obtenerModelo(){
		PersonajeModel pm = new PersonajeModel();
		pm.setNombre(this.getNombre());
		pm.setCastaId(this.casta.getId());
		pm.setRazaId(this.raza.getId());
		pm.setFuerza(this.getFuerza());
		pm.setInteligencia(this.getInteligencia());
		pm.setDestreza(this.getDestreza());
		pm.setEnergia(this.getEnergia());
		pm.setMana(this.getMana());
		pm.setNivel(this.getNivel());
		pm.setSalud(this.getSalud());
		return pm;
	}
}
