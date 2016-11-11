package prograavanzada2016.anotherworld.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class Servidor{
	
	private int cantidadDeConexiones;
	private boolean enLinea;
	private int puerto=444;
	private ServerSocket serverSocket;
	
	public ArrayList<ClienteServicio> clientesSala1;
	
	public Servidor() throws IOException{
		this.clientesSala1 = new ArrayList<>();
		this.cantidadDeConexiones=0;
		this.serverSocket = new ServerSocket(puerto);
	}
	
	public void iniciarServidor() throws IOException, SQLException{
		this.enLinea=true;
		while(this.enLinea){
			System.out.println("Esperando conexion...");
			Socket socket = serverSocket.accept();
			System.out.println("Cliente conectado...");
			this.cantidadDeConexiones++;
			ServidorManager servidorManager=null;
			
			ClienteServicio cs = new ClienteServicio(socket,cantidadDeConexiones);
			this.clientesSala1.add(cs);
			
			//servidorManager = new ServidorManager(socket,this.salaDeChat1);
			servidorManager = new ServidorManager(socket,this.clientesSala1,cantidadDeConexiones);
			Thread instancia = new Thread(servidorManager);
			instancia.start();
		}
	}
	
	public void cerrarServidor(){
		this.enLinea=false;
	}
}
