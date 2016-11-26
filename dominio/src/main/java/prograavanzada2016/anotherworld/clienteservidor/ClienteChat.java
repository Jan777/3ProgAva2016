package prograavanzada2016.anotherworld.clienteservidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

public class ClienteChat implements Runnable{
	Socket socket;
	Scanner input;
	Scanner send = new Scanner(System.in);
	PrintWriter out;
	String nombre;
	public ClienteChat(Socket socket,String nombre){
		this.socket=socket;
		this.nombre=nombre;
	}

	@Override
	public void run(){
				try {
					input = new Scanner(socket.getInputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out = new PrintWriter(socket.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.flush();
				try {
					chechStream();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	
	public void chechStream() throws Exception{
		while(true){
			receive();
		}
	}
	
	public void receive() throws Exception{
		if(input.hasNext()){
			String message = input.nextLine();
			System.out.println(message);
		}
	}
	
	public void send(String string) throws Exception{
		out.println(this.nombre+": "+string);
		out.flush();
	}
	
	public void disconnected()throws Exception{
		this.send(this.nombre+" disconnected");
		out.flush();
		socket.close();
		System.exit(0);
	}
}
