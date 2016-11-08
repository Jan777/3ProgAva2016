package prograavanzada2016.anotherworld.cliente;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.comandos.ComandoLogin;
import prograavanzada2016.anotherworld.observer.ILogin;
import prograavanzada2016.anotherworld.observer.SubjectLogin;

public class ClienteManager implements Runnable, SubjectLogin{
	private Socket socket;
	private Scanner entrada;
	private PrintWriter salida;
	private boolean estaLogueado = false;
	private Gson gson;
	private String user;
	private String password;
	
	//variables observadoras
	private static ArrayList<ILogin> observadoresLogin = new ArrayList<>();
	//fin de variables observadoras
	
	public ClienteManager(ClienteJugable clienteJugable,String user, String password){
		//agrego los eventos para los observadores
		observadoresLogin.add(clienteJugable);
		this.socket=clienteJugable.getSocket();
		gson = new Gson();
	}

	@Override
	public void run() {
		try{
			try{
				entrada = new Scanner(socket.getInputStream());
				salida = new PrintWriter(socket.getOutputStream());
				salida.flush();
				
				/*if(!estaLogueado){
					Thread.sleep(2000);
					salida.println(new ComandoLogin(this.user, this.password));
					estaLogueado=true;
				}*/
				
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
		//aca va el observador
		if(entrada.hasNext()){
			System.out.println("HUBO UN MENSAJE NUEVO");
			String message = entrada.nextLine();
			this.notifyAllObservers(message);
			System.out.println(message);
		}
	}
	
	public void sendMensaje(int codigo, String json){
		MensajeEnviable mensajeEnviable = new MensajeEnviable(codigo, json);
		salida.println(gson.toJson(mensajeEnviable));
		salida.flush();
	}
	
	public void sendMensaje(String mensaje){
		System.out.println("El mensaje es:"+ mensaje);
		salida.println(mensaje);
		salida.flush();
	}
	
	public String reciveMessage(){
		if(entrada.hasNext()){
			String message = entrada.nextLine();
			return message;
		}
		return "";
	}
	
	public void disconnected()throws Exception{
		this.sendMensaje(0, "disconnected");
		salida.flush();
		socket.close();
		System.exit(0);
	}

	@Override
	public void attach(ILogin login) {
		observadoresLogin.add(login);		
	}

	@Override
	public void dettach(ILogin login) {
		observadoresLogin.remove(login);
	}

	@Override
	public void notifyAllObservers(String msg) {
		for(int i=0; i<observadoresLogin.size(); i++){
			observadoresLogin.get(i).update(msg);
		}
	}
}
