package dominio;

import prograavanzada2016.anotherworld.castas.*;
import prograavanzada2016.anotherworld.entities.*;
import prograavanzada2016.anotherworld.objetos.*;
import prograavanzada2016.anotherworld.objetos.armas.*;
import prograavanzada2016.anotherworld.razas.*;
import org.junit.*;

public class PersonajeTest 
{
	@Test
	public void creacionNivelAtaque() throws Exception
	{
		Personaje p1 = new Personaje("pedro", new Humano(), new Curandero());
		Personaje p2 = new Personaje("pedro", new Humano(), new Mago());
		Personaje p3 = new Personaje("pedro", new Humano(), new Guerrero());
		p1.mostrarStats();
		p2.mostrarStats();
		p3.mostrarStats();
		System.out.println("--------------------------");
		p2.subirNivel();
		p2.subirNivel();
		p2.subirNivel();
		p2.subirNivel();
		p2.subirNivel();
		p2.lanzarHabilidad(1, p1);
		System.out.println("**********************");
		p1.equiparArma(new LibroMagicoParaNovatos());
		p1.atacar(p2);
		p1.atacar(p2);
		p1.atacar(p2);
		p1.atacar(p2);
		p2.mostrarStats();
		System.out.println("**********************");
		p1.mostrarStats();
		//p2.mostrarStats();
		//System.out.println("**********************");
		/*p1.equiparArma(new EspadaDeMadera());
		p2.equiparArmadura(new ArmaduraDeCuero());
		p1.atacar(p2);
		p1.mostrarStats();
		System.out.println("**********************");
		p2.mostrarStats();*/
	}

}
