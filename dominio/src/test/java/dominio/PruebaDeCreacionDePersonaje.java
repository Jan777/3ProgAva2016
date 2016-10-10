package dominio;

import org.junit.Assert;
import org.junit.Test;

import prograavanzada2016.anotherworld.castas.*;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.razas.*;

public class PruebaDeCreacionDePersonaje {

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
