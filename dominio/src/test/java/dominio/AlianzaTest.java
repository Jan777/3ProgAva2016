package dominio;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.combates.ArenaPvE;
import prograavanzada2016.anotherworld.combates.GrupoEnemigos;
import prograavanzada2016.anotherworld.combates.GrupoPersonajes;
import prograavanzada2016.anotherworld.enemigos.Dragon;
import prograavanzada2016.anotherworld.entities.Enemigo;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.razas.Humano;
import prograavanzada2016.anotherworld.razas.Orco;

public class AlianzaTest {
	/**
	 * Historia de usuario Nro.6
	 * @throws Exception 
	 * */
	@Test
	public void creacionAlianza() throws Exception{
		Personaje anselmo = new Personaje("Anselmo", new Orco(), new Guerrero());
		anselmo.crearAlianza("Las Cobras");
		
		Assert.assertEquals("Las Cobras", anselmo.getNombreAlianza());
	}
	
	@Test
	public void agregaPersonajeAlianza() throws Exception{
		Personaje anselmo = new Personaje("Anselmo", new Orco(), new Guerrero());
		Personaje braulio = new Personaje("Braulio", new Humano(), new Mago());
		
		anselmo.crearAlianza("Las Cobras");
		anselmo.añadirPersonajeAlianza(braulio);
		
		Assert.assertEquals("Las Cobras", braulio.getNombreAlianza());
	}
	
	/**
	 * Historia de usuario Nro.7
	 * 
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
	 * Historia de usuario Nro.9
	 * 
	 * **/
	@Test
	public void salirDeLaAlianza() throws Exception{
		Personaje anselmo = new Personaje("Anselmo", new Orco(), new Guerrero());
		Personaje braulio = new Personaje("Braulio", new Humano(), new Mago());
		
		anselmo.crearAlianza("Las Cobras");
		anselmo.añadirPersonajeAlianza(braulio);
		
		Assert.assertEquals("Las Cobras", braulio.getNombreAlianza());
		
		braulio.abandonarAlianzaActual();
		Assert.assertEquals("", braulio.getNombreAlianza());
	}
}
