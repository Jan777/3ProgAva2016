package prograavanzada2016.anotherworld.cliente;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.comandos.Comando;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.observer.ILogin;
import prograavanzada2016.anotherworld.user.Usuario;

public class ClienteJugable implements ILogin{
	private int idCliente;
	private Socket socket;
	private ClienteManager clienteManager;
	private Usuario usuario;
	private ArrayList<ClienteJugable> otrosClientes;
	
	public ClienteJugable(String server, int port) throws UnknownHostException, IOException {
		this.otrosClientes=new ArrayList<>();
		this.socket = new Socket(server, port);
		clienteManager = new ClienteManager(this);
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
			this.setUsuario(gson.fromJson(mensaje[3], Usuario.class));
			System.out.println("Me logre conectar y mi id es: " +this.idCliente);
		}else{
			//FAIL
		}		
	}	
}
