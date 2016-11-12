package prograavanzada2016.anotherworld.cliente;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import prograavanzada2016.anotherworld.comandos.ComandoLogin;
import prograavanzada2016.anotherworld.interfaces.VentanaPrincipal;
import prograavanzada2016.anotherworld.mensajes.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.LoginMessageResponse;
import prograavanzada2016.anotherworld.mensajes.MessageDeserializer;
import prograavanzada2016.anotherworld.mensajes.PersonajeConsultaResponseMessage;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.RespuestaGenericaMessage;
import prograavanzada2016.anotherworld.observer.ILogin;
import prograavanzada2016.anotherworld.observer.SubjectLogin;
import prograavanzada2016.anotherworld.servicios.ServiceLocator;

public class ClienteManager implements Runnable, SubjectLogin{
	private Socket socket;
	private Scanner entrada;
	private PrintWriter salida;
	private Gson gson;
	private VentanaPrincipal ventanaPrincipal;
	private ClienteJugable clienteJugable;
	
	//variables observadoras
	private static ArrayList<ILogin> observadoresLogin = new ArrayList<>();
	//fin de variables observadoras
	
	public ClienteManager(ClienteJugable clienteJugable){
		//agrego los eventos para los observadores
		//observadoresLogin.add(clienteJugable);
		//observadoresLogin.add(ventanaPrincipal);
		this.socket=clienteJugable.getSocket();
		this.clienteJugable = clienteJugable;
		gson = new Gson();
	}

	@Override
	public void run() {
		try{
			try{
				ventanaPrincipal = new VentanaPrincipal(this.clienteJugable);
				System.out.println("ventana principal activada");
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
	
	public void chechStream() throws Exception{
		while(true){
			receive();
		}
	}
	
	public void receive() throws Exception{
		if(entrada.hasNext()){
			System.out.println("HUBO UN MENSAJE NUEVO");
			String mensajeDeEntrada = entrada.nextLine();
			System.out.println("El servidor dice: "+mensajeDeEntrada);
			//this.notifyAllObservers(message);
			MessageDeserializer deserializer = new MessageDeserializer("type");
	        
	        RegisterMessageTypes(deserializer);
	    	
	        Gson gson = new GsonBuilder().registerTypeAdapter(RawMessage.class, deserializer).create();
	        
	        RawMessage deserializedCharMessage = gson.fromJson(mensajeDeEntrada, RawMessage.class);
	        deserializedCharMessage.message.servicio = ServiceLocator.localizar(deserializedCharMessage.type,this.clienteJugable);
	        deserializedCharMessage.message.Resolve();
		}
	}
	
	private void RegisterMessageTypes(MessageDeserializer deserializer) {
		deserializer.registerMessageType("loginResponse", LoginMessageResponse.class);
        deserializer.registerMessageType("personajeConsultaResponse", PersonajeConsultaResponseMessage.class);	
        deserializer.registerMessageType("personajeNuevoConectado", PersonajeConsultaResponseMessage.class);
        deserializer.registerMessageType("respuestaGenericaNuevoUsuario", RespuestaGenericaMessage.class);
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
