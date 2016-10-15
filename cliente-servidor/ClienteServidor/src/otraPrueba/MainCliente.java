package otraPrueba;

import java.net.Socket;

public class MainCliente
{
	public static void main(String[] args) throws Exception
	{
		final String ipServer = Propiedades.getInstance().getIp();
		final int puerto = Propiedades.getInstance().getPuerto();
		
		try
		{
			Socket socket = new Socket(ipServer, puerto);
			System.out.println("Te conectaste a: "+ ipServer);
			
			Cliente chat = new Cliente(socket);
			Thread thread = new Thread(chat);
			thread.start();
			
			Thread.sleep(5000);
			
			chat.send("Mensaje 1: cliente a servidor.");
			Thread.sleep(10000);
			chat.send("Mensaje 2: cliente a servidor.");
			Thread.sleep(10000);
			chat.send("Mensaje 3: cliente a servidor.");
			
			chat.disconnected();
		}
		catch(Exception e)
		{
			
		}
	}

}
