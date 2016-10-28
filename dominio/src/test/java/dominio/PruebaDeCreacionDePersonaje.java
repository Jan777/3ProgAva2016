package dominio;

import org.junit.Assert;
import org.junit.Test;

import prograavanzada2016.anotherworld.castas.*;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.razas.*;

public class PruebaDeCreacionDePersonaje {

	//Historia 1
	@Test
	public void crearPersonaje() throws Exception
	{
		Personaje p = new Personaje("pedro", new Orco(), new Curandero());
		Assert.assertEquals(Orco.class , p.getRaza().getClass());
		
		p.setCasta(new Guerrero());
		Assert.assertEquals(Guerrero.class, p.getCasta().getClass());
	}
	
	//Historia 2
	@Test
	public void ganarExperienciaYSubirDeNivel() throws Exception
	{
		Personaje pepe = new Personaje("pepe", new Humano(), new Guerrero());
		Assert.assertEquals(1, pepe.getNivel());
		pepe.sumarExperiencia(20);
		Assert.assertEquals(2, pepe.getNivel());
	}
	
	@Test
	public void ataqueEntrePersonajes() throws Exception{
		Personaje p1 = new Personaje("pedro", new Orco(), new Curandero());
		Personaje p2 = new Personaje("pedro", new Orco(), new Mago());
		Personaje p3 = new Personaje("pedro", new Humano(), new Guerrero());
		
		int saludAProbar = p3.getSalud();
		p1.atacar(p3);
		int saludResultado = p3.getSalud();
		
		Assert.assertEquals(saludResultado, saludAProbar-(p1.getAtaque()-p3.getDefensa()));
	}
}
