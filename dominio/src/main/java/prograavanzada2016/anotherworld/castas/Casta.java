package prograavanzada2016.anotherworld.castas;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.habilidades.Habilidad;

public abstract class Casta {
	
	protected String nombre;
	protected ArrayList<Habilidad> habilidades;
	
	protected void setNombre(String nombre){
		this.nombre=nombre;
	};
	
	public String getNombre(){
		return this.nombre;
	}
	
	public ArrayList<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}
	
	public Habilidad getHabilidad(int id){
		for(Habilidad habilidad : this.habilidades){
			if(habilidad.getId()==id){
				return habilidad;
			}
		}
		return null;
	}

	
	public abstract void saludar();
		
	public abstract void guardarHabilidades();
	
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

	public abstract void calcularStats(Personaje personaje);
}
