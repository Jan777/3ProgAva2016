package prograavanzada2016.anotherworld.castas;

import prograavanzada2016.anotherworld.entities.Personaje;

public abstract class Casta {
	
	protected String nombre;
	
	protected void setNombre(String nombre){
		this.nombre=nombre;
	};
	
	public String getNombre(){
		return this.nombre;
	}
	
	public abstract void calcularStats(Personaje personaje) throws Exception;
	
	public abstract void saludar();
	
	protected void aumentarStatsSegunCasta(Personaje personaje, int fuerza, int destreza, int inteligencia, int salud, int mana, int energia){
		personaje.aumentarFuerza(fuerza);
		personaje.aumentarDestreza(destreza);
		personaje.aumentarInteligencia(inteligencia);
		personaje.aumentarSalud(salud);
		personaje.aumentarMana(mana);
		personaje.aumentarEnergia(energia);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casta other = (Casta) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
