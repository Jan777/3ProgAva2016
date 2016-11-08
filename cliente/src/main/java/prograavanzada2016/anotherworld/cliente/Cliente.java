package prograavanzada2016.anotherworld.cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	private String server="localhost";
	final int puerto = 444;
	private Socket socket;
	private ClienteManager clienteManager;
	
	
	public Cliente() throws IOException{
		//socket = new Socket(server, puerto);
		clienteManager = new ClienteManager(socket);
		Thread instancia = new Thread(clienteManager);
		instancia.start();
	}
	
	public void desconectarse() throws Exception{
		clienteManager.disconnected();
	}
	
	public void enviarMensaje(int codigo, String json){
		clienteManager.sendMensaje(codigo, json);
	}
	
	public String recibirMensaje(){
		return clienteManager.reciveMessage(); //devuelve un MensajeEnviable en forma de json
	}
}
