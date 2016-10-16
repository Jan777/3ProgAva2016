package prograavanzada2016.anotherworld.entities;

import prograavanzada2016.anotherworld.castas.Casta;
import prograavanzada2016.anotherworld.habilidades.Habilidad;
import prograavanzada2016.anotherworld.objetos.*;
import prograavanzada2016.anotherworld.objetos.armaduras.ObjetoArmadura;
import prograavanzada2016.anotherworld.objetos.armas.ObjetoArma;
import prograavanzada2016.anotherworld.razas.Raza;

public class Personaje extends Ente{
	
	protected Casta casta;
	protected Raza raza;
	
	protected ObjetoArma objetoArma;
	protected ObjetoArmadura objetoArmadura;
	
	//experiencia que tiene el jugador en el momento
	protected int experienciaActual;
	//experiencia que necesita el jugador para subir de nivel
	protected int experienciaLimite;
	
	public Personaje(String nombre, Raza raza, Casta casta) throws Exception {
		super(nombre);
		this.raza=raza;
		this.casta=casta;
		this.casta.calcularStats(this);
		this.casta.guardarHabilidades();
		//cuando se crea un personaje se le debe modificar sus stats segun la raza
		//this.casta.calcularStats(this, raza);
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
	public void despuesDeAtacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serHechizado(Habilidad habilidad) {
		// TODO Auto-generated method stub
		
	}
	
	public int getExperienciaActual() {
		return experienciaActual;
	}
	
	public void subirNivel() {
		this.nivel = this.nivel+1;
	}

	public void sumarExperiencia(int experiencia) {
		this.experienciaActual += experiencia;
		if(this.experienciaActual>=this.experienciaLimite){
			this.subirNivel();
		}
	}
	
	public void equiparArma(ObjetoArma objetoArma){
		if(objetoArma.getCasta().equals(this.getCasta())){
			this.objetoArma=objetoArma;
			this.setAtaque(objetoArma.getBonusAtaque());
			this.setPuntosDeEnergiaPorAtaque(objetoArma.getPuntosDeEnergiaPorAtaque());
		}else{
			System.out.println("No se puede equipar el arma, reload reload");
		}
	}
	
	public void equiparArmadura(ObjetoArmadura objetoArmadura){
		this.objetoArmadura=objetoArmadura;
		this.setDefensa(objetoArmadura.getBonusDefensa());
	}
	
	public void lanzarHabilidad(int id,Ente enteObjetivo){
		Habilidad habilidad = this.getCasta().getHabilidad(id);
		if(habilidad.getNivelRequerido()<=this.getNivel()){
			habilidad.LanzarHechizo(this, enteObjetivo);
		}else{
			System.out.println("Siento que aun me falta energias para esta tecnica.");
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
	
	
	
	public void mostrarStats(){
		System.out.println("Nombre: "+super.getNombre());
		System.out.println("Nivel: "+super.getNivel());
		System.out.println("Fuerza: "+this.getFuerza());
		System.out.println("Destreza: "+this.getDestreza());
		System.out.println("Inteligecia: "+this.getInteligencia());
		System.out.println("Salud: "+this.getSalud());
		System.out.println("Salud en uso: "+this.getSaludEnUso());
		System.out.println("Mana: "+this.getMana());
		System.out.println("Mana en uso: "+this.getManaEnUso());
		System.out.println("Energia: "+this.getEnergia());
		System.out.println("Energia en uso:"+this.energiaEnUso);
	}
}
