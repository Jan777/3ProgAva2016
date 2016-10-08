package prograavanzada2016.anotherworld.NPCs;

import prograavanzada2016.anotherworld.entities.Ente;

public abstract class NPC extends Ente
{
	// ** Atributos ** \\
	// Indica si va a atacar o no a los jugadores cercanos, sin que lo provoquen.
	protected boolean esPasivo;
	// Indica la experiencia base que obtiene un jugador al matarlo, se agrega o no un bonus en base a la diferencia de nivel.
	protected int expBaseQueOtorga;
	protected int bonusExpDifNivel = 100;
	// Hay que agregar los items que va a dropear!
	// Habilidades?
	
	// ** Constructores ** \\
	protected NPC (String nombre, int nivel, int salud, int energia, int mana, int fuerza,
				   int destreza, int inteligencia, boolean esPasivo, int expBaseQueOtorga)
	{
		super(nombre, nivel, salud, energia, mana, fuerza, destreza, inteligencia);
		this.esPasivo = esPasivo;
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
	
}
