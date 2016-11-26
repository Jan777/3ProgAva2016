package prograavanzada2016.anotherworld.habilidades;

import prograavanzada2016.anotherworld.entities.Ente;

public class RafagaAlada extends Habilidad
{
	public RafagaAlada()
	{
		this.id = 2;
		this.costeMana = 0;
		this.costeEnergia = 25;
	}
	
	@Override
	public void LanzarHechizo(Ente enteLanzador, Ente enteObjetivo)
	{	
		if(enteLanzador.restarEnergiaEnUso(this.costeEnergia))
		{
			enteObjetivo.serAtacado(enteLanzador.calcularPuntosDeAtaque());
		}
		else
		{
			//System.out.println("Fallo el lanzamiento");
		}	
	}

}
