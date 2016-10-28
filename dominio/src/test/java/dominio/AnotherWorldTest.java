package dominio;

import org.junit.Assert;
import org.junit.Test;

import prograavanzada2016.anotherworld.NPCs.Dragon;
import prograavanzada2016.anotherworld.NPCs.NPC;
import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.combates.Loot;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.mapas.Mapa;
import prograavanzada2016.anotherworld.mapas.MapaNivelUno;
import prograavanzada2016.anotherworld.mapas.Zona;
import prograavanzada2016.anotherworld.objetos.LibroMagicoParaNovatos;
import prograavanzada2016.anotherworld.razas.Humano;
import prograavanzada2016.anotherworld.razas.Orco;

public class AnotherWorldTest {
	
	/**
	 * Historia de usuario Nº1
	 * @throws Exception 
	 * */
		@Test
		public void crearPersonaje() throws Exception
		{
			Personaje p = new Personaje("pedro", new Orco(), new Curandero());
			Assert.assertEquals(Orco.class , p.getRaza().getClass());
			
			p.setCasta(new Guerrero());
			Assert.assertEquals(Guerrero.class, p.getCasta().getClass());
		}
		
		/**
		 * Historia de usuario Nº2
		 * @throws Exception 
		 * */
		@Test
		public void ganarExperienciaYSubirDeNivel() throws Exception
		{
			Personaje pepe = new Personaje("pepe", new Humano(), new Guerrero());
			Assert.assertEquals(1, pepe.getNivel());
			pepe.sumarExperiencia(20);
			Assert.assertEquals(2, pepe.getNivel());
		}
	
		/**
		 * Historia de usuario Nº3
		 * @throws Exception 
		 * */
	@Test
	public void eliminarYSubirDeNivel() throws Exception
	{
		Personaje pers = new Personaje("Aragorn", new Humano(), new Guerrero());
		Dragon reinaldo = new Dragon("Reinaldo", 1, 10, 100, 300, 5, 7, 3, false, 200);
		Assert.assertEquals(0, pers.getExperienciaActual());
		while(reinaldo.isEstaVivo())
		{
			pers.atacar(reinaldo);
		}
		Assert.assertEquals(5, pers.getExperienciaActual());
	}
	
	/**
	 * Historia de usuario Nº4
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
	 * Historia de usuario Nº6 y 7
	 * @throws Exception 
	 * */
	
		@Test
		public void creacionAlianza() throws Exception
		{
			Personaje anselmo = new Personaje("Anselmo", new Orco(), new Guerrero());
			anselmo.crearAlianza("Las Cobras");
			
			Assert.assertEquals("Las Cobras", anselmo.getNombreAlianza());
		}
		
		@Test
		public void agregaPersonajeAlianza() throws Exception
		{
			Personaje anselmo = new Personaje("Anselmo", new Orco(), new Guerrero());
			Personaje braulio = new Personaje("Braulio", new Humano(), new Mago());
			
			anselmo.crearAlianza("Las Cobras");
			anselmo.añadirPersonajeAlianza(braulio);
			
			Assert.assertEquals("Las Cobras", braulio.getNombreAlianza());
		}
		
		@Test
		public void calculoBonusExperiencia() throws Exception
		{
			Personaje anselmo = new Personaje("Anselmo", new Orco(), new Guerrero());
			Personaje braulio = new Personaje("Braulio", new Humano(), new Mago());
			Personaje yolanda = new Personaje("Yolanda", new Orco(), new Guerrero());
			
			anselmo.crearAlianza("Hell's Satans");
			anselmo.añadirPersonajeAlianza(braulio);
			anselmo.añadirPersonajeAlianza(yolanda);
			
			Assert.assertEquals(3, yolanda.getCantMienbrosAlianza());
			Assert.assertEquals(1.15, yolanda.getBonusExp(), 0.001);
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
	
	//--------------------------------------------------------
	
	@Test
	public void pruebasDragon()
	{
		Mapa mapa = new MapaNivelUno();
		Loot loot = new Loot();
		Dragon reinaldo = new Dragon("Reinaldo", 1, 10, 100, 300, 5, 7, 3, false, 200, mapa, 5, 5);
		
		// Acá se supone que un personaje mata al buen Reinaldo :)
		reinaldo.restarSaludEnUso(10);
		reinaldo.dropearObjetos(loot);
		loot.mostrarObjetos();
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
