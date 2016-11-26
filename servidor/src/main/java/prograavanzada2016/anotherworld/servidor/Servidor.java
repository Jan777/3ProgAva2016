package prograavanzada2016.anotherworld.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import prograavanzada2016.anotherworld.modelos.InteligenciaArtificial;
import prograavanzada2016.anotherworld.resources.LogAnother;


public class Servidor{
	
	private int cantidadDeConexiones;
	private boolean enLinea;
	private int puerto=444;
	private ServerSocket serverSocket;
	
	public static ArrayList<ClienteServicio> clientesSala1;
	public static ArrayList<InteligenciaArtificial> enemigos;
	
	public Servidor() throws IOException{
		this.enemigos=new ArrayList<>();
		this.iniciarEnemigos(enemigos);
		this.clientesSala1 = new ArrayList<>();
		this.cantidadDeConexiones=0;
		this.serverSocket = new ServerSocket(puerto);
	}
	
	private void iniciarEnemigos(ArrayList<InteligenciaArtificial> lista) {
		for(int x=0;x<2;x++){
			InteligenciaArtificial ai = new InteligenciaArtificial(x+1);
			lista.add(ai);
		}
	}

	public void iniciarServidor() throws IOException, SQLException{
		this.enLinea=true;
		while(this.enLinea){
			LogAnother.getInstance().logSentence("Esperando conexion...");
			Socket socket = serverSocket.accept();
			LogAnother.getInstance().logSentence("Cliente conectado...");
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
