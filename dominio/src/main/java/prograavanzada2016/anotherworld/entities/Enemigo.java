package prograavanzada2016.anotherworld.entities;

import java.util.*;
import java.util.Map.Entry;

import prograavanzada2016.anotherworld.combates.ArenaPvE;
import prograavanzada2016.anotherworld.combates.Loot;
import prograavanzada2016.anotherworld.habilidades.Habilidad;
import prograavanzada2016.anotherworld.objetos.*;

public abstract class Enemigo extends Ente
{
	// ** Atributos ** \\
	// Indica la experiencia base que obtiene un jugador al matarlo, se agrega o no un bonus en base a la diferencia de nivel.
	protected int expBaseQueOtorga;
	protected int bonusExpDifNivel = 100;
	protected List<Habilidad> habilidades;
	// Por cada objeto, tengo una probabilidad de que sea o no dropeado.
	protected Map<Objeto, Integer> objetosDropeables = new HashMap<Objeto, Integer>();
	
	protected ArenaPvE arenaPvE;
	
	// ** Constructores ** \\
	protected Enemigo (String nombre, int nivel, int salud, int energia, int mana, int fuerza,int destreza, int inteligencia, int expBaseQueOtorga) throws Exception
	{
		super(nombre, nivel, salud, energia, mana, fuerza, destreza, inteligencia);
		this.expBaseQueOtorga = expBaseQueOtorga;
	}
	
	// ** Métodos ** \\
	protected int obtenerExperiencia(int nivelPersonaje)
	{
		int bonusExp = 0;
		
		if (nivelPersonaje < this.nivel)
			bonusExp = (this.nivel - nivelPersonaje) * this.bonusExpDifNivel;
		
		return this.expBaseQueOtorga + bonusExp; 
	}
	
	@Override
	public void dropearObjetos(Loot loot)
	{
		if (!this.estaVivo)
		{
			for (Entry entry : this.objetosDropeables.entrySet()) 
			{
				int probDropeo = (int) entry.getValue();
				boolean loDropea = new Random().nextInt(100) <= probDropeo;
				
				if(loDropea)
				{
					Objeto objeto = (Objeto) entry.getKey();
					try {
						loot.agregarObjeto(objeto);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public ArenaPvE getArena() {
		return arenaPvE;
	}

	public void setArena(ArenaPvE arenaPvE) {
		this.arenaPvE = arenaPvE;
	}
	
	
	
	public int getExpBaseQueOtorga() {
		return expBaseQueOtorga;
	}

	public void setExpBaseQueOtorga(int expBaseQueOtorga) {
		this.expBaseQueOtorga = expBaseQueOtorga;
	}

	@Override
	public void despuesDeMorir() {
		this.getArena().setCantidadDeExperiencia(this.getExpBaseQueOtorga());
		
	}
	
}
