package prograavanzada2016.anotherworld.entities;

import prograavanzada2016.anotherworld.castas.Casta;
import prograavanzada2016.anotherworld.habilidades.Habilidad;
import prograavanzada2016.anotherworld.razas.Raza;

public class Personaje extends Ente{
	
	protected Casta casta;
	protected Raza raza;
	
	protected int ataque;
	protected int defensa;
	
	//experiencia que tiene el jugador en el momento
	protected int experienciaActual;
	//experiencia que necesita el jugador para subir de nivel
	protected int experienciaLimite;
	
	public Personaje(String nombre, Raza raza, Casta casta) throws Exception {
		super(nombre);
		this.raza=raza;
		this.casta=casta;
		//cuando se crea un personaje se le debe modificar sus stats segun la raza
		this.casta.calcularStats(this, raza);
	}

	@Override
	public void serAtacado(int daño) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calcularPuntosDeAtaque() {
		// TODO Auto-generated method stub
		return 0;
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

	public int getExperienciaLimite() {
		return experienciaLimite;
	}

	public void setExperienciaLimite(int experienciaLimite) {
		this.experienciaLimite = experienciaLimite;
	}

}
