package dominio;

import org.junit.Test;

import junit.framework.Assert;
import prograavanzada2016.anotherworld.castas.*;
import prograavanzada2016.anotherworld.entities.*;
import prograavanzada2016.anotherworld.razas.*;

public class AlianzaTest
{
	// ** Historias 6 y 7 ** \\
	
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
}
