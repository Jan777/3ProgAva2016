package otraPrueba;

public class MainServidor
{

	public static void main(String[] args)
	{
		// Creo el server como un thread y lo dejo escuchando nuevas conexiones.
		Servidor s = new Servidor();
		s.start();
		System.out.println("asdf");
	}

}
