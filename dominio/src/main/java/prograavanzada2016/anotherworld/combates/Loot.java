package prograavanzada2016.anotherworld.combates;

import java.util.*;
import prograavanzada2016.anotherworld.objetos.*;

public class Loot
{
	// �sta clase va a resolver el tema de qu� personaje va a obtener el objeto deseado.
	// Por ejemplo: si 2 personajes quieren una espada del loot, van a "tirar los dados" y el que saque
	// el n�mero m�s alto se la lleva.
	private List<Objeto> objetos;
	
	public Loot()
	{
		this.objetos = new ArrayList<Objeto>();
	}
	
	public void agregarObjeto(Objeto objeto)
	{
		this.objetos.add(objeto);
	}
	
	public void mostrarObjetos()
	{
		for(Objeto o : this.objetos)
			System.out.println(o.getNombre());
	}
}
