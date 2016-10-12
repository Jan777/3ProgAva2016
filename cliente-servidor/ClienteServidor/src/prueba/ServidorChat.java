package prueba;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServidorChat implements Runnable{
	Socket socket;
	private Scanner input;
	private PrintWriter out;
	String message = "";
	
	public ServidorChat(Socket socket){
		this.socket=socket;
	}
	
	public void checkConnection()throws Exception{
		if(!this.socket.isConnected()){
			
			for(int x=0; x<Servidor.connectionArray.size(); x++){
				if(Servidor.connectionArray.get(x)==this.socket){
					Servidor.connectionArray.remove(x);
				}
			}
			
		}
	}
	
	
	@Override
	public void run() {
		
		try{
			try{
				input = new Scanner(socket.getInputStream());
				out = new PrintWriter(socket.getOutputStream());
				
				while(true){
					this.checkConnection();
					
					if(!input.hasNext()){
						return;
					}
					
					message = input.nextLine();
					System.out.println("El cliente dice: "+message);
					
					for(int x=0; x<Servidor.connectionArray.size(); x++){
						Socket tempSocket = Servidor.connectionArray.get(x);
						PrintWriter tempOut = new PrintWriter(tempSocket.getOutputStream());
						tempOut.println(message);
						tempOut.flush();
						System.out.println("mensaje enviado a: "+tempSocket.getLocalAddress().getHostName());
					}
				}
			}finally{
				socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
