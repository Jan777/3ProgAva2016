package otraPrueba;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente implements Runnable
{
	Socket socket;
	Scanner input;
	PrintWriter out;
	Scanner send = new Scanner(System.in);
	
	public Cliente (Socket socket)
	{
		this.socket=socket;
	}

	@Override
	public void run() 
	{
		try
		{
			try
			{
				input = new Scanner(socket.getInputStream());
				out = new PrintWriter(socket.getOutputStream());
				out.flush();
				chechStream();			
			}
			finally
			{
				this.socket.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void chechStream()
	{
		while(true)
		{
			receive();
		}
	}
	
	public void receive()
	{
		if(input.hasNext())
		{
			String message = input.nextLine();
			
			System.out.println(message);
		}
	}
	
	public void send(String string)
	{
		out.println(string);
		out.flush();
	}
	
	public void disconnected() throws Exception
	{
		out.println("me voy");
		out.flush();
		socket.close();
		System.exit(0);
	}

}
