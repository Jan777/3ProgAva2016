package prograavanzada2016.anotherworld.NPCs;

import java.util.ArrayList;
import java.util.Arrays;

import prograavanzada2016.anotherworld.entities.Ente;
import prograavanzada2016.anotherworld.habilidades.*;
import prograavanzada2016.anotherworld.mapas.Mapa;
import prograavanzada2016.anotherworld.objetos.*;

public class Dragon extends NPC
{

	public Dragon(String nombre, int nivel, int salud, int energia, int mana, int fuerza, int destreza,
				  int inteligencia, boolean esPasivo, int expBaseQueOtorga)
	{
		super(nombre, nivel, salud, energia, mana, fuerza, destreza, inteligencia, esPasivo, expBaseQueOtorga);
		this.estaVivo = true;
		this.esPasivo = false;
		habilidades = new ArrayList<Habilidad>(Arrays.asList(new AlientoDeFuegoNegro(), new RafagaAlada()));
	}
	
	public Dragon(String nombre, int nivel, int salud, int energia, int mana, int fuerza, int destreza,int inteligencia, boolean esPasivo, int expBaseQueOtorga,Mapa mapa){
		super(nombre, nivel, salud, energia, mana, fuerza, destreza, inteligencia, esPasivo, expBaseQueOtorga);
		this.esPasivo = false;
		habilidades = new ArrayList<Habilidad>(Arrays.asList(new AlientoDeFuegoNegro(), new RafagaAlada()));
		this.mapa=mapa;
	}
	
	public Dragon(String nombre, int nivel, int salud, int energia, int mana, int fuerza, int destreza,int inteligencia, boolean esPasivo, int expBaseQueOtorga,Mapa mapa,int posicionX, int posicionY){
		super(nombre, nivel, salud, energia, mana, fuerza, destreza, inteligencia, esPasivo, expBaseQueOtorga);
		this.esPasivo = false;
		habilidades = new ArrayList<Habilidad>(Arrays.asList(new AlientoDeFuegoNegro(), new RafagaAlada()));
		this.mapa=mapa;
		this.posicionX=posicionX;
		this.posicionY=posicionY;
		this.objetosDropeables.put(new Einlanzer(), 10);
		this.objetosDropeables.put(new EspadaDeMadera(), 100);
		this.objetosDropeables.put(new LibroMagicoParaNovatos(), 90);
	}

	@Override
	public int calcularPuntosDeAtaque()
	{
		return (int)(this.ataque + (this.destreza * 0.4));
	}

	@Override
	public void despuesDeAtacar(Ente ente)
	{
		int boostSalud = (int) ((int) this.saludEnUso * 0.05);
		this.aumentarSalud(boostSalud);
	}

	@Override
	public void serAtacado(int daño)
	{
		this.restarSaludEnUso(daño);
	}

	@Override
	public void serAtacadoConMagia(int daño) 
	{
		daño -= daño * 0.15;
		this.restarSaludEnUso(daño);
	}
	
	@Override
	public void serHechizado(HabilidadPersonaje habilidad)
	{
	}
}
