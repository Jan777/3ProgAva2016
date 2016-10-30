package dominio;

import org.junit.Assert;
import org.junit.Test;

import prograavanzada2016.anotherworld.castas.Curandero;
import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.razas.Orco;

public class PersonajeTest {
	/**
	 * Historia de usuario Nro.1
	 * @throws Exception 
	 * */
	@Test
	public void crearPersonaje() throws Exception{
		//se crea un orco curandero
		Personaje pedro = new Personaje("pedro", new Orco(), new Curandero());
		Assert.assertEquals(Orco.class , pedro.getRaza().getClass());
		Assert.assertEquals(Curandero.class, pedro.getCasta().getClass());
	}
	
	
}
