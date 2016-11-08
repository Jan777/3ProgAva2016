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
					//this.dispatcherDeAcciones(gson.fromJson(mensajeDeEntrada, Mensaje.class));
					Comando comando = gson.fromJson(mensajeDeEntrada, Comando.class);
					System.out.println(gson.toJson(comando));
					this.dispatcherDeAcciones(comando);
				}
			}finally{
				socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	
	public void dispatcherDeAcciones(Comando comando) throws IOException, DAOException, InterruptedException{
		int codigo = Integer.parseInt(comando.getRequestFromClient().substring(0,1));
		String mensajeDeCliente = comando.getRequestFromClient().substring(0,comando.getRequestFromClient().length());
		switch(codigo){
			//la opcion 1 es la opcion de login me llega un usuario y contraseña
			case 1:
				//formato de respuesta
				//OK idCliente
				//FAIL
				String datos[]=mensajeDeCliente.split(" ");
				if(datos[1].equals("pepe")){
					ComandoLogin comandoLogin = new ComandoLogin();
					comandoLogin.armarMensajeDesdeServidor("OK "+this.idCliente);
					boolean unaVez=true;
					for(int x=0; x<this.clientesSala.size() && unaVez; x++){
						if(this.clientesSala.get(x).getId()==this.idCliente){
							Socket socketDeSala =this.clientesSala.get(x).getSocket();
							if(socketDeSala!=null && !socketDeSala.isClosed()){
								PrintWriter salida = new PrintWriter(socketDeSala.getOutputStream());
								salida.println(gson.toJson(comandoLogin));
								salida.flush();
								System.out.println("mensaje enviado a: "+socketDeSala.getLocalAddress().getHostName());
							}
							unaVez=false;
						}						
					}
				}
			break;
			
			case 2:
				//opcion 2 es logeo
//				Usuario usuario = gson.fromJson(mensajeEnviable.getMensaje(), Usuario.class);
//				if(usuarioDAO.buscar(usuario) == 1)
//				{
//					MensajeEnviable mensaje = new MensajeEnviable(2, gson.toJson(usuario));
//					gson.toJson(mensaje);
//					//salida.write(mensaje);
//				}
			break;
			
			case 3:
				//Personaje personaje = gson.fromJson(mensajeEnviable.getMensaje(), Personaje.class);
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
