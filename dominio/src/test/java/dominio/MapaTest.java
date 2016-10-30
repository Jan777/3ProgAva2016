package dominio;

import org.junit.Assert;
import org.junit.Test;

import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.entities.Enemigo;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.mapas.MapaNivelUno;
import prograavanzada2016.anotherworld.mapas.Zona;
import prograavanzada2016.anotherworld.razas.Humano;

public class MapaTest {
	/**
	 * Historia de usuario Nro.10
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
		Enemigo dragonMenor = zonaRandom1.getEnemigos().get(0);
		Assert.assertFalse(personaje.puedeEntrarEnCombate(dragonMenor));
		
		//el personaje esta en la misma zona
		zonaRandom1.transportarAlCentroDeLaZona(personaje);
		Assert.assertTrue(personaje.puedeEntrarEnCombate(dragonMenor));
		
		//el personaje esta en distinta zona
		Zona zonaRandom2 = mapa.getZona3();
		Enemigo dragonMayor = zonaRandom2.getEnemigos().get(0);
		Assert.assertFalse(personaje.puedeEntrarEnCombate(dragonMayor));
		
		//el personaje esta en la misma zona
		zonaRandom2.transportarAlCentroDeLaZona(personaje);
		Assert.assertTrue(personaje.puedeEntrarEnCombate(dragonMayor));		
	}
	
	/**
	 * Historia de usuario Nro.11
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
