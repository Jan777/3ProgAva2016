package dominio;

import org.junit.Assert;
import org.junit.Test;

import prograavanzada2016.anotherworld.castas.Guerrero;
import prograavanzada2016.anotherworld.castas.Mago;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.razas.Humano;

public class HabilidadesTest {
	
	/**
	 * Historia de usuario Nro.2
	 * @throws Exception 
	 * */
	@Test
	public void ganarExperienciaYObtenerNuevasHabilidades() throws Exception{
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
}
