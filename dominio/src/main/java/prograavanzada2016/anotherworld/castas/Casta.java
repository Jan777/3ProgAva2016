package prograavanzada2016.anotherworld.castas;

import java.util.ArrayList;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.habilidades.HabilidadPersonaje;

public abstract class Casta {
	
	protected int id;
	protected String nombre;
	protected ArrayList<HabilidadPersonaje> habilidades;
	
	protected void setNombre(String nombre){
		this.nombre=nombre;
	};
	
	public String getNombre(){
		return this.nombre;
	}
	
	public ArrayList<HabilidadPersonaje> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<HabilidadPersonaje> habilidades) {
		this.habilidades = habilidades;
	}
	
	public HabilidadPersonaje getHabilidad(int id){
		for(HabilidadPersonaje habilidad : this.habilidades){
			if(habilidad.getId()==id){
				return habilidad;
			}
		}
		return null;
	}

	
	public abstract void saludar();
		
	public abstract void guardarHabilidades();
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public abstract void calcularStats(Personaje personaje);
}
