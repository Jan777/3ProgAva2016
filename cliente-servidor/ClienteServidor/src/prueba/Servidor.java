package prueba;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {
	public static ArrayList<Socket> connectionArray = new ArrayList<>();
	public static ArrayList<String> users = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		try{
			final int PORT = 444;
			ServerSocket SERVER = new ServerSocket(PORT);
			
			
			while(true){
				System.out.println("Esperando un cliente");
				Socket socket = SERVER.accept();
				connectionArray.add(socket);
				
				System.out.println("Cliente conectado desde: "+ socket.getLocalAddress().getHostName());
				
				//metodo loco
				ServidorChat chat = new ServidorChat(socket);
				Thread instancia = new Thread(chat);
				instancia.start();
			}
		}catch(Exception e){
			
		}
	}
	
	public static void addUserName(Socket x) throws Exception{
		Scanner input = new Scanner(x.getInputStream());
		String userName = input.nextLine();
		
		users.add(userName);
	}
}
