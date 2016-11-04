package prograavanzada2016.anotherworld.cliente;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

import com.google.gson.Gson;

public class ClienteManager implements Runnable{
	private Socket socket;
	private Scanner entrada;
	private PrintWriter salida;
	
	private Gson gson;
	
	public ClienteManager(Socket socket){
		this.socket=socket;
		gson = new Gson();
	}

	@Override
	public void run() {
		try{
			try{
				entrada = new Scanner(socket.getInputStream());
				salida = new PrintWriter(socket.getOutputStream());
				salida.flush();
				chechStream();			
			}finally{
				this.socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void chechStream(){
		while(true){
			receive();
		}
	}
	
	public void receive(){
		if(entrada.hasNext()){
			String message = entrada.nextLine();
			System.out.println(message);
		}
	}
	
	public void sendMensaje(String string){
		MensajeEnviable mensajeEnviable = new MensajeEnviable(1, string);
		salida.println(gson.toJson(mensajeEnviable));
		salida.flush();
	}
	
	public void disconnected()throws Exception{
		this.sendMensaje("disconnected");
		salida.flush();
		socket.close();
		System.exit(0);
	}
}
