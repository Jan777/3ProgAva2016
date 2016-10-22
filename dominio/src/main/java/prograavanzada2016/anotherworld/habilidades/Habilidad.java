package prograavanzada2016.anotherworld.habilidades;

import prograavanzada2016.anotherworld.entities.Ente;

public abstract class Habilidad
{
	protected int id;
	protected int costeMana;
	protected int costeEnergia;
	
	public abstract void LanzarHechizo(Ente enteLanzador, Ente enteObjetivo);
	
	public int getId()
	{
		return this.id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getCosteMana() 
	{
		return this.costeMana;
	}
	public void setCosteMana(int costeMana)
	{
		this.costeMana = costeMana;
	}
	
	public int getCosteEnergia()
	{
		return this.costeEnergia;
	}

}
