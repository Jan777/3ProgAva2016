package prueba;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) throws Exception{
		String server="localhost";
		try{
			final int PORT = 444;
			Socket socket = new Socket(server, PORT);
			System.out.println("Te conectaste a: "+server);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("hola soy un socket");
			out.flush();
			//metodo re loco
			ClienteChat chat = new ClienteChat(socket);
			Thread thread = new Thread(chat);
			thread.start();
			
			Thread.sleep(5000);
			chat.send("jejeje");
			//Thread.sleep(20000);
			chat.send("jojojo");
			//Thread.sleep(20000);
			chat.send("jajaja");
			chat.disconnected();
		}catch(Exception e){
			
		}
	}
}
