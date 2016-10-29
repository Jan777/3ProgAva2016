package dominio;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.combates.ArenaPvE;
import prograavanzada2016.anotherworld.combates.GrupoEnemigos;
import prograavanzada2016.anotherworld.combates.GrupoPersonajes;
import prograavanzada2016.anotherworld.combates.Loot;
import prograavanzada2016.anotherworld.enemigos.Dragon;
import prograavanzada2016.anotherworld.entities.Enemigo;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.mapas.Mapa;
import prograavanzada2016.anotherworld.mapas.MapaNivelUno;
import prograavanzada2016.anotherworld.mapas.Zona;
import prograavanzada2016.anotherworld.objetos.LibroMagicoParaNovatos;
import prograavanzada2016.anotherworld.razas.Humano;
import prograavanzada2016.anotherworld.razas.Orco;

public class AnotherWorldTest {
	
	/**
	 * Historia de usuario N�1
	 * @throws Exception 
	 * */
		@Test
		public void crearPersonaje() throws Exception
		{
			//se crea un orco curandero
			Personaje pedro = new Personaje("pedro", new Orco(), new Curandero());
			Assert.assertEquals(Orco.class , pedro.getRaza().getClass());
			Assert.assertEquals(Curandero.class, pedro.getCasta().getClass());
		}
		
		/**
		 * Historia de usuario N�2
		 * @throws Exception 
		 * */
		@Test
		public void ganarExperienciaYSubirDeNivel() throws Exception
		{
			Personaje pepe = new Personaje("pepe", new Humano(), new Guerrero());
			int saludDePepe = pepe.getSaludEnUso();
			Personaje pablo = new Personaje("pablo", new Humano(), new Mago());
			//se lanzan misilesArcanos que son de nivel 1
			pablo.lanzarHabilidad(3, pepe);
			Assert.assertTrue(saludDePepe>pepe.getSaludEnUso());
			
			saludDePepe = pepe.getSaludEnUso();
			
			//se lanza la bola de fuego que es de nivel 5 pero el personaje no podra ejecutar la tecnica
			pablo.lanzarHabilidad(1, pepe);
			Assert.assertTrue(pepe.getSaludEnUso()==saludDePepe);
			
			//se suben 5 niveles
			pablo.sumarExperiencia(1000);
			pablo.sumarExperiencia(1000);
			pablo.sumarExperiencia(1000);
			pablo.sumarExperiencia(1000);
			
			Assert.assertEquals(5, pablo.getNivel());
			
			//se lanza con exito la habilidad bola de fuego
			pablo.lanzarHabilidad(1, pepe);
			Assert.assertTrue(saludDePepe>pepe.getSaludEnUso());
		}
	
		/**
		 * Historia de usuario N�3
		 * @throws Exception 
		 * */
	@Test
	public void eliminarYSubirDeNivel() throws Exception
	{
		//se crean personajes
		Personaje pers = new Personaje("Aragorn", new Humano(), new Guerrero());
		Dragon reinaldo = new Dragon("Reinaldo", 1, 10, 100, 300, 5, 7, 3, false, 200);
		
		//se crea lo necesario para la arena
		ArrayList<Enemigo> gge = new ArrayList<>();
		gge.add(reinaldo);
		GrupoEnemigos ge = new GrupoEnemigos(gge);
		
		ArrayList<Personaje> ggp = new ArrayList<>();
		ggp.add(pers);
		GrupoPersonajes gp = new GrupoPersonajes(ggp);
		
		ArenaPvE arena = new ArenaPvE(ge, gp);
		
		int nivelPersonaje = pers.getNivel();
		
		//hora de batallar
		arena.armarTurnos();
		
		//mato al dragon y subio nivel
		Assert.assertTrue(nivelPersonaje<pers.getNivel());
	}
	
	/**
	 * Historia de usuario N�4
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
	 * Historia de usuario N�5
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
	 * Historia de usuario N�6
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
		
		@Test
		public void agregaPersonajeAlianza() throws Exception
		{
			Personaje anselmo = new Personaje("Anselmo", new Orco(), new Guerrero());
			Personaje braulio = new Personaje("Braulio", new Humano(), new Mago());
			
			anselmo.crearAlianza("Las Cobras");
			anselmo.a�adirPersonajeAlianza(braulio);
			
			Assert.assertEquals("Las Cobras", braulio.getNombreAlianza());
		}
	/**
	 * Historia de usuario N�7
	 * metodo no terminado del todo
	 * */
		
	public void eliminarYSubirDeNivelEnAlianza() throws Exception{
		//se crean personajes
		Personaje pers = new Personaje("Aragorn", new Humano(), new Guerrero());
		Personaje pers2 = new Personaje("Aragorn2", new Humano(), new Guerrero());
		Dragon reinaldo = new Dragon("Reinaldo", 1, 10, 100, 300, 5, 7, 3, false, 200);
		
		//se crea lo necesario para la arena
		ArrayList<Enemigo> gge = new ArrayList<>();
		gge.add(reinaldo);
		GrupoEnemigos ge = new GrupoEnemigos(gge);
		
		ArrayList<Personaje> ggp = new ArrayList<>();
		ggp.add(pers);
		ggp.add(pers2);
		GrupoPersonajes gp = new GrupoPersonajes(ggp);
		
		ArenaPvE arena = new ArenaPvE(ge, gp);
		
		int nivelPersonaje = pers.getNivel();
		int nivelPersonaje2 = pers2.getNivel();
		
		//hora de batallar
		arena.armarTurnos();
		
		//mato al dragon y subio nivel
		Assert.assertTrue(nivelPersonaje<pers.getNivel());
		Assert.assertTrue(nivelPersonaje2<pers2.getNivel());
	}
	
	
	/**
	 * Historia de usuario N�8
	 * **/
	@Test
	public void historialDeVictorias() throws Exception{
		Personaje pedrito = new Personaje("pedrito", new Orco(), new Mago());
		Assert.assertTrue(pedrito.getHistorialDeVictorias()==0);
		Assert.assertTrue(pedrito.getHistorialDeDerrotas()==0);
	}		
	
	/**
	 * Historia de usuario N�9
	 * 
	 * **/
	@Test
	public void salirDeLaAlianza() throws Exception{
		Personaje anselmo = new Personaje("Anselmo", new Orco(), new Guerrero());
		Personaje braulio = new Personaje("Braulio", new Humano(), new Mago());
		
		anselmo.crearAlianza("Las Cobras");
		anselmo.a�adirPersonajeAlianza(braulio);
		
		Assert.assertEquals("Las Cobras", braulio.getNombreAlianza());
		
		braulio.abandonarAlianzaActual();
		Assert.assertEquals("", braulio.getNombreAlianza());
	}
		
	
	/**
	 * Historia de usuario N�10
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
	 * Historia de usuario N�11
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
/*	
	@Test
	public void pruebasDragon()
	{
		Mapa mapa = new MapaNivelUno();
		Loot loot = new Loot();
		Dragon reinaldo = new Dragon("Reinaldo", 1, 10, 100, 300, 5, 7, 3, false, 200, mapa, 5, 5);
		
		// Ac� se supone que un personaje mata al buen Reinaldo :)
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
	
	@Test
		public void calculoBonusExperiencia() throws Exception
		{
			Personaje anselmo = new Personaje("Anselmo", new Orco(), new Guerrero());
			Personaje braulio = new Personaje("Braulio", new Humano(), new Mago());
			Personaje yolanda = new Personaje("Yolanda", new Orco(), new Guerrero());
			
			anselmo.crearAlianza("Hell's Satans");
			anselmo.a�adirPersonajeAlianza(braulio);
			anselmo.a�adirPersonajeAlianza(yolanda);
			
			Assert.assertEquals(3, yolanda.getCantMienbrosAlianza());
			Assert.assertEquals(1.15, yolanda.getBonusExp(), 0.001);
		}
	*
	*/
}
