package dominio;

import org.junit.Assert;
import org.junit.Test;

import prograavanzada2016.anotherworld.NPCs.NPC;
import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.mapas.MapaNivelUno;
import prograavanzada2016.anotherworld.mapas.Zona;
import prograavanzada2016.anotherworld.objetos.LibroMagicoParaNovatos;
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
		
		//el libro necesita un minimo de nivel 2 para poder equipar
		personaje.equiparArma(new LibroMagicoParaNovatos());
		Assert.assertEquals(ataquePersonaje, personaje.getAtaque());
		
		personaje.subirNivel();
		
		//al subir al nivel 2 puedo equiparme y pegar mas fuerte
		personaje.equiparArma(new LibroMagicoParaNovatos());
		Assert.assertEquals(ataquePersonaje+ataqueArma, personaje.getAtaque());
	}
	
	/**
	 * Historia de usuario Nº10
	 * @throws Exception 
	 * */
	@Test
	public void encuentroConVariosEnemigosPorElMapa() throws Exception{
		Personaje personaje = new Personaje("Anduin", new Humano(), new Curandero());
		//al crearse el mapa me crea enemigos en ella
		MapaNivelUno mapa = new MapaNivelUno();
		personaje.setMapa(mapa);
		
		//el personaje esta en distinta zona
		Zona zonaRandom1 = mapa.getZona2();
		NPC dragonMenor = zonaRandom1.getEnemigos().get(0);
		Assert.assertFalse(personaje.puedeEntrarEnCombate(dragonMenor));
		
		//el personaje esta en la misma zona
		zonaRandom1.transportarAlCentroDeLaZona(personaje);
		Assert.assertTrue(personaje.puedeEntrarEnCombate(dragonMenor));
		
		//el personaje esta en distinta zona
		Zona zonaRandom2 = mapa.getZona3();
		NPC dragonMayor = zonaRandom2.getEnemigos().get(0);
		Assert.assertFalse(personaje.puedeEntrarEnCombate(dragonMayor));
		
		//el personaje esta en la misma zona
		zonaRandom2.transportarAlCentroDeLaZona(personaje);
		Assert.assertTrue(personaje.puedeEntrarEnCombate(dragonMayor));		
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
