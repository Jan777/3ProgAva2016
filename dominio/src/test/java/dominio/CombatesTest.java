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

public class CombatesTest {
	/**
	 * Historia de usuario Nro.3
	 * @throws Exception 
	 * */
	@Test
	public void eliminarYSubirDeNivel() throws Exception{
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
	 * Historia de usuario Nro.8
	 * **/
	@Test
	public void historialDeVictorias() throws Exception{
		Personaje pedrito = new Personaje("pedrito", new Orco(), new Mago());
		Assert.assertTrue(pedrito.getHistorialDeVictorias()==0);
		Assert.assertTrue(pedrito.getHistorialDeDerrotas()==0);
	}
}
