package prograavanzada2016.anotherworld.entities;

import prograavanzada2016.anotherworld.model.Casta;
import prograavanzada2016.anotherworld.model.Habilidad;
import prograavanzada2016.anotherworld.model.Raza;

public class Personaje extends Ente{
	
	protected Casta casta;
	protected Raza raza;
	
	public Personaje(String nombre, Raza raza, Casta casta) {
		super(nombre);
		this.raza=raza;
		this.casta=casta;
		//cuando se crea un personaje se le debe modificar sus stats segun la raza
		this.casta.calcularStats(this, raza);
	}

	@Override
	public void serAtacado(int daño) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calcularPuntosDeAtaque() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void despuesDeAtacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serHechizado(Habilidad habilidad) {
		// TODO Auto-generated method stub
		
	}

}
