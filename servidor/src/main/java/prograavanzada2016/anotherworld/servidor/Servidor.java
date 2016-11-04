package prograavanzada2016.anotherworld.servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor
{
	public ArrayList<Socket> salaDeChat1;
	public ArrayList<Socket> salaDeChat2;
	public ArrayList<Socket> salaDeChat3;
	private int cantidadDeConexiones;
	private boolean enLinea;
	private int puerto=444;
	private ServerSocket serverSocket;
	
	public Servidor() throws IOException{
		this.salaDeChat1 = new ArrayList<>();
		this.salaDeChat2 = new ArrayList<>();
		this.salaDeChat3 = new ArrayList<>();
		this.cantidadDeConexiones=0;
		this.serverSocket = new ServerSocket(puerto);
	}
	
	public void iniciarServidor() throws IOException{
		this.enLinea=true;
		while(this.enLinea){
			System.out.println("Esperando conexion...");
			Socket socket = serverSocket.accept();
			System.out.println("Cliente conectado...");
			this.cantidadDeConexiones++;
			ServidorManager servidorManager=null;
			this.salaDeChat1.add(socket);
			servidorManager = new ServidorManager(socket,this.salaDeChat1);
			Thread instancia = new Thread(servidorManager);
			instancia.start();
		}
	}
	
	public void cerrarServidor(){
		this.enLinea=false;
	}
}
