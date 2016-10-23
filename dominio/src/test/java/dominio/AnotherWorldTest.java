package dominio;

import org.junit.Assert;
import org.junit.Test;

import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.mapas.MapaNivelUno;
import prograavanzada2016.anotherworld.objetos.armas.LibroMagicoParaNovatos;
import prograavanzada2016.anotherworld.razas.Humano;

public class AnotherWorldTest {
	
	/**
	 * Historia de usuario Nº5
	 * @throws Exception 
	 * */
	@Test
	public void subirNivelParaPoderEquiparUnArma() throws Exception{
		Personaje personaje = new Personaje("Anduin", new Humano(), new Curandero());
		int ataquePersonaje = personaje.getAtaque();
		int ataqueArma = new LibroMagicoParaNovatos().getBonusAtaque();
		Assert.assertEquals(ataquePersonaje, personaje.getAtaque());
		
		personaje.subirNivel();
		
		personaje.equiparArma(new LibroMagicoParaNovatos());
		Assert.assertEquals(ataquePersonaje+ataqueArma, personaje.getAtaque());
	}
	
	/**
	 * Historia de usuario Nº11
	 * @throws Exception 
	 * */
	@Test
	public void noPuedeEntrarEnCombateEnUnaCiudad() throws Exception{
		Personaje personaje = new Personaje("Anduin", new Humano(), new Curandero());
		Personaje personaje2 = new Personaje("Goku", new Humano(), new Guerrero());
		
		//cada mapa contiene 4 zonas, en esta clase de mapa, la misma, contiene una ciudad que es un territorio neutral
		MapaNivelUno mapa = new MapaNivelUno();
		personaje.setMapa(mapa);
		personaje2.setMapa(mapa);
		
		//ambos estan en la posicion 0-0 donde esta la ciudad
		Assert.assertFalse(!personaje.puedeEntrarEnCombate(personaje2));
		
		//los movemos de la zona segura
		personaje.moverse(350, 350);
		personaje2.moverse(350, 300);
		
		Assert.assertTrue(personaje.puedeEntrarEnCombate(personaje2));
	}
}
