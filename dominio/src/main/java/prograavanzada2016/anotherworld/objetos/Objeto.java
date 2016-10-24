package prograavanzada2016.anotherworld.objetos;

import prograavanzada2016.anotherworld.castas.Casta;

public abstract class Objeto 
{
	protected String nombre;
	protected Casta casta;
	protected int nivelMinimo;
	
	public String getNombre()
	{
		return this.nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public Casta getCasta()
	{
		return this.casta;
	}
	public void setCasta(Casta casta)
	{
		this.casta = casta;
	}
	
	public int getNivelMinimo()
	{
		return this.nivelMinimo;
	}
	public void setNivelMinimo(int nivelMinimo)
	{
		this.nivelMinimo = nivelMinimo;
	}

}
