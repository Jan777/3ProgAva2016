package prograavanzada2016.anotherworld.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import prograavanzada2016.anotherworld.DAO.DAOException;
import prograavanzada2016.anotherworld.DAO.UsuarioDAO;
import prograavanzada2016.anotherworld.comandos.Comando;
import prograavanzada2016.anotherworld.comandos.ComandoLogin;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.mensajes.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.MessageDeserializer;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.servicios.ServiceLocator;
import prograavanzada2016.anotherworld.user.Usuario;

public class ServidorManager implements Runnable{
	private Socket socket;
	private Scanner entrada;
	private String mensajeDeEntrada ="";
	private ArrayList<Socket> salaDeChat;
	private ArrayList<ClienteServicio> clientesSala;
	private Gson gson;
	private UsuarioDAO usuarioDAO;
	private Connection conn = null;
    private Statement stat = null;
    private int idCliente=0;
    
	public ServidorManager(Socket socket, ArrayList<Socket> salaDeChat) throws SQLException, IOException{
		this.socket=socket;
		this.salaDeChat=salaDeChat;
		this.gson = new Gson();
		//usuarioDAO = new UsuarioDAO(conn, stat);
	}
	
	public ServidorManager(Socket socket,ArrayList<ClienteServicio> clientesSala,int idCliente) throws SQLException, IOException{
		this.socket=socket;
		this.clientesSala=clientesSala;
		this.idCliente=idCliente;
		this.gson = new Gson();
		//usuarioDAO = new UsuarioDAO(conn, stat);
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
					System.out.println("Manda algo");
					this.checkConnection();
					if(!entrada.hasNext()){
						return;
					}
					mensajeDeEntrada = entrada.nextLine();
					
					System.out.println("El cliente dice: "+mensajeDeEntrada);
					
					MessageDeserializer deserializer = new MessageDeserializer("type");
				        
			        RegisterMessageTypes(deserializer);
			    	
			        Gson gson = new GsonBuilder().registerTypeAdapter(RawMessage.class, deserializer).create();
			        
			        RawMessage deserializedCharMessage = gson.fromJson(mensajeDeEntrada, RawMessage.class);
			        deserializedCharMessage.message.idCliente=this.idCliente;
			        deserializedCharMessage.message.servicio = ServiceLocator.localizar(deserializedCharMessage.type);
			        deserializedCharMessage.message.Resolve();
					
				}
			}finally{
				socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	
	private void RegisterMessageTypes(MessageDeserializer deserializer) {
		deserializer.registerMessageType("login", LoginMessage.class);
        //deserializer.registerMessageType("createCharacter", CreateCharacterMessage.class);	
	}

}
