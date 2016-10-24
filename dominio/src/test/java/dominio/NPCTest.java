package dominio;

import org.junit.*;

import prograavanzada2016.anotherworld.NPCs.*;
import prograavanzada2016.anotherworld.combates.*;
import prograavanzada2016.anotherworld.mapas.*;

public class NPCTest
{
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
}
