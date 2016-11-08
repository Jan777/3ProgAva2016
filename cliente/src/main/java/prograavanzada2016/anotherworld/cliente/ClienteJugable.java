package prograavanzada2016.anotherworld.cliente;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.comandos.Comando;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.observer.ILogin;

public class ClienteJugable implements ILogin{
	private int idCliente;
	private Socket socket;
	private ClienteManager clienteManager;
	private Personaje personaje;
	
	public ClienteJugable(String server, int port,String user, String password) throws UnknownHostException, IOException {
		this.socket = new Socket(server, port);
		clienteManager = new ClienteManager(this, user, password);
		Thread instancia = new Thread(clienteManager);
		instancia.start();
	}
		
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ClienteManager getClienteManager() {
		return clienteManager;
	}

	public void setClienteManager(ClienteManager clienteManager) {
		this.clienteManager = clienteManager;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
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
	
	public void enviarComando(Comando comando){
		clienteManager.sendMensaje(comando.enviarComando());
	}
	
	
	
	@Override
	public void update(String response) {
		Gson gson = new Gson();
		Comando comando = gson.fromJson(response, Comando.class); 
		String mensaje[] = comando.getResponseFromServer().split(" ");
		if(mensaje[1].equals("OK")){
			int idCliente = Integer.parseInt(mensaje[2]);
			this.idCliente=idCliente;
			System.out.println("Me logre conectar y mi id es: " +this.idCliente);
		}else{
			//FAIL
		}		
	}	
}
