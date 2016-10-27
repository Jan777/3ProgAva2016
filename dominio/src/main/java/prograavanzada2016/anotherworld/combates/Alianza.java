package prograavanzada2016.anotherworld.combates;

import java.util.*;
import prograavanzada2016.anotherworld.entities.*;

public class Alianza
{
	private String nombre;
	private float bonusExp;
	private int cantMiembros;
	private List<Personaje> miembros;
	
	// ** Constructores ** \\
	public Alianza(String nombre)
	{
		this.nombre = nombre;
		this.cantMiembros = 0;
		this.bonusExp = 1;
		this.miembros = new ArrayList<Personaje>();
	}
	
	public Alianza(String nombre, Personaje p)
	{
		this(nombre);
		this.agregarMiembro(p);
	}
	
	// ** Métodos Públicos ** \\
	public void agregarMiembro(Personaje p)
	{
		this.miembros.add(p);
		this.cantMiembros++;
		this.recalcularBonus();
	}
	
	public void quitarMiembro(Personaje p)
	{
		this.miembros.remove(p);
		this.cantMiembros--;
		this.recalcularBonus();
	}
	
	public List<String> obtenerMiembros()
	{
		List<String> miembros = new ArrayList<String>();
		
		for (Personaje p : this.miembros)
			miembros.add(p.getNombre());
		
		return miembros;
	}
	
	// ** Métodos Privados ** \\
	private void recalcularBonus()
	{
		this.bonusExp = (this.cantMiembros > 1) ? 1 + (this.cantMiembros / 20) : 1;
	}
	
}