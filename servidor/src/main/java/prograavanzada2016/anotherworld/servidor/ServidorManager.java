package prograavanzada2016.anotherworld.servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.DAO.UsuarioDAO;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.user.Usuario;

public class ServidorManager implements Runnable{
	private Socket socket;
	private Scanner entrada;
	private String mensajeDeEntrada ="";
	private ArrayList<Socket> salaDeChat;
	private Gson gson;
	private UsuarioDAO usuarioDAO;
	public ServidorManager(Socket socket, ArrayList<Socket> salaDeChat){
		this.socket=socket;
		this.salaDeChat=salaDeChat;
		gson = new Gson();
		//usuarioDAO = new UsuarioDAO(conn, stat) 
	}
	
	public void checkConnection()throws Exception{
		if(!this.socket.isConnected()){
			for(int x=0; x<this.salaDeChat.size(); x++){
				if(this.salaDeChat.get(x).equals(this.socket)){
					this.salaDeChat.remove(x);
				}
			}
			
		}
	}
	
	
	@Override
	public void run() {
		
		try{
			try{
				entrada = new Scanner(socket.getInputStream());
				new PrintWriter(socket.getOutputStream());
				
				while(true){
					this.checkConnection();
					if(!entrada.hasNext()){
						return;
					}
					mensajeDeEntrada = entrada.nextLine();
					System.out.println("El cliente dice: "+mensajeDeEntrada);
					this.dispatcherDeAcciones(gson.fromJson(mensajeDeEntrada, MensajeEnviable.class));
				}
			}finally{
				socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void dispatcherDeAcciones(MensajeEnviable mensajeEnviable) throws IOException{
		switch(mensajeEnviable.getCodigo()){
			case 1:
				//opcion 1 es mensaje normal
				for(int x=0; x<this.salaDeChat.size(); x++){
					Socket socketDeSala =this.salaDeChat.get(x);
					if(socketDeSala!=null && !socketDeSala.isClosed()){
						PrintWriter salida = new PrintWriter(socketDeSala.getOutputStream());
						salida.println(mensajeEnviable.getMensaje());
						salida.flush();
						System.out.println("mensaje enviado a: "+socketDeSala.getLocalAddress().getHostName());
					}
				}
			break;
			
			case 2:
				//opcion 2 es logeo
				Usuario usuario = gson.fromJson(mensajeEnviable.getMensaje(), Usuario.class);
				//UsuarioDAO usuario;
				//usuario.borrar(usuario);
			break;
			
			case 3:
				Personaje personaje = gson.fromJson(mensajeEnviable.getMensaje(), Personaje.class);
			break;
			
			case 4:
				
			break;
			default:
			break;
		}
		
	}
	
	
	public void dispatcherDeMensajes(int codigo, String json){
		
		
		
	}
}
