package prograavanzada2016.anotherworld.habilidades;

import prograavanzada2016.anotherworld.entities.Ente;

public class AlientoDeFuegoNegro extends Habilidad 
{
	public AlientoDeFuegoNegro()
	{
		this.id = 1;
		this.costeMana = 30;
		this.costeEnergia = 0;
	}

	@Override
	public void LanzarHechizo(Ente enteLanzador, Ente enteObjetivo)
	{
		if(enteLanzador.restarManaEnUso(this.costeMana))
		{
			enteObjetivo.serAtacadoConMagia(enteLanzador.getInteligencia()*10);
		}
		else
		{
			//System.out.println("Fallo el lanzamiento");
		}	
	}

}
