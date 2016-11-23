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

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import prograavanzada2016.anotherworld.DAO.DAOException;
import prograavanzada2016.anotherworld.DAO.UsuarioDAO;
import prograavanzada2016.anotherworld.comandos.Comando;
import prograavanzada2016.anotherworld.comandos.ComandoLogin;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.mensajes.MessageDeserializer;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.ConsultarPersonajesConectadosMessage;
import prograavanzada2016.anotherworld.mensajes.request.CrearPersonajeNuevoMessage;
import prograavanzada2016.anotherworld.mensajes.request.EnemigoConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.request.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.request.MoverMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.request.UsuarioNuevoMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.resources.Logger;
import prograavanzada2016.anotherworld.servicios.ServiceLocator;

public class ServidorManager implements Runnable{
	private Socket socket;
	private Scanner entrada;
	private String mensajeDeEntrada ="";
	private ArrayList<Socket> salaDeChat;
	private ArrayList<ClienteServicio> clientesSala;
	private Gson gson;
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
		for(int x=0; x<Servidor.clientesSala1.size(); x++){
			if(!Servidor.clientesSala1.get(x).getSocket().isConnected()){
				this.salaDeChat.remove(x);
				System.out.println("se removio uno");
			}
		}
	}
	
	
	@Override
	public void run() {
		
		Logger logger = null;
		try{
			try{
				logger = Logger.getInstance();
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
			JOptionPane.showMessageDialog(null, "Ocurrió un error, para más información"+System.getProperty("line.separator") 
			+" vea el LOG del sistema.", "ERROR", JOptionPane.ERROR_MESSAGE);
			logger.log(e.getMessage());
			//e.printStackTrace();
		}
		
	}
	

	
	private void RegisterMessageTypes(MessageDeserializer deserializer) throws Exception{
		deserializer.registerMessageType("login", LoginMessage.class);
        deserializer.registerMessageType("personajeConsulta", PersonajeConsultaMessage.class);
        deserializer.registerMessageType("usuarioNuevo", UsuarioNuevoMessage.class);
        deserializer.registerMessageType("crearPersonaje", CrearPersonajeNuevoMessage.class);
        deserializer.registerMessageType("moverPersonaje", MoverMessage.class);
        deserializer.registerMessageType("buscarPersonajes", ConsultarPersonajesConectadosMessage.class);
        deserializer.registerMessageType("buscarEnemigos", EnemigoConsultaMessage.class);
	}

}
