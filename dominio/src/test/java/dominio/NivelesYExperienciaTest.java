package dominio;

import org.junit.Assert;
import org.junit.Test;

import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.objetos.LibroMagicoParaNovatos;
import prograavanzada2016.anotherworld.razas.Humano;

public class NivelesYExperienciaTest {
	/**
	 * Historia de usuario Nro.4
	 * @throws Exception 
	 * */
	@Test
	public void subirDeNivelYAsignarPuntosAdicionales() throws Exception
	{
		Personaje pers = new Personaje("Aragorn", new Humano(), new Guerrero());
		Assert.assertEquals(1, pers.getNivel());
		pers.subirNivel();
		//Cada vez que sube de nivel tiene 5 puntos adicionales para poder sumar a cualquiera de sus atributos
		Assert.assertEquals(2, pers.getNivel());
		pers.aumentarFuerza(2);
		pers.aumentarInteligencia(3);
		//Inicialmente el guerrero tiene 15 de fuerza
		Assert.assertEquals(17, pers.getFuerza());
		//Inicialmente el guerrero tiene 5 de inteligencia
		Assert.assertEquals(8, pers.getInteligencia());
	}
	
	/**
	 * Historia de usuario Nro.5
	 * @throws Exception 
	 * */
	@Test
	public void subirNivelParaPoderEquiparUnArma() throws Exception{
		Personaje personaje = new Personaje("Anduin", new Humano(), new Curandero());
		int ataquePersonaje = personaje.getAtaque();
		int ataqueArma = new LibroMagicoParaNovatos().getBonusAtaque();
		
		//el libro necesita un minimo de nivel 2 para poder equipar
		personaje.equiparArma(new LibroMagicoParaNovatos());
		Assert.assertEquals(ataquePersonaje, personaje.getAtaque());
		
		personaje.subirNivel();
		
		//al subir al nivel 2 puedo equiparme y pegar mas fuerte
		personaje.equiparArma(new LibroMagicoParaNovatos());
		Assert.assertEquals(ataquePersonaje+ataqueArma, personaje.getAtaque());
	}
}
