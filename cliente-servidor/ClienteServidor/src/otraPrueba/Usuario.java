package otraPrueba;

import java.net.Socket;;

public class Usuario 
{
	private String nombre;
	Socket socket;
	
	public Usuario(String nombre, Socket socket)
	{
		this.nombre = nombre;
		this.socket = socket;
	}

}
