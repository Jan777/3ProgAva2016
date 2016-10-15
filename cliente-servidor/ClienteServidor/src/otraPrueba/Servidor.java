package otraPrueba;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Servidor extends Thread
{
	private boolean permitirConexionesEntrantes;
	final int puerto;
	private ServerSocket serverSocket;
	private List<SalaChat> salas;
	
	public Servidor()
	{
		this.puerto = Propiedades.getInstance().getPuerto();
		this.permitirConexionesEntrantes = true;
		this.salas = new ArrayList<SalaChat>();
		
		this.salas.add(new SalaChat("Sala 1"));
		this.salas.add(new SalaChat("Sala 2"));
		this.salas.add(new SalaChat("Sala 3"));
		
		try 
		{
			this.serverSocket = new ServerSocket(this.puerto);
		} 
		catch (IOException e) 
		{
		}
	}
	
	private void escuchar()
	{
		while (permitirConexionesEntrantes)
		{
			System.out.println("Esperando un cliente...");
			
			try 
			{
				Socket socket = serverSocket.accept();
				
				// ¿A qué sala mando al usuario que se acaba de conectar?
				// ¿Nombre de usuario?
				// Por ahora mando a todos a la sala 1 y sin nombre :/
				this.salas.get(0).agregarUsuarioASala(new Usuario("", socket));
			} 
			catch (IOException e) 
			{
				System.out.println("Se produjo un error, un cliente no se pudo conectar.");
				System.out.println(e.getMessage());
			}
		}
	}
	
	

	@Override
	public void run()
	{
		this.escuchar();
	}
}
