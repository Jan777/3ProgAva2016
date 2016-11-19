package prograavanzada2016.anotherworld.cliente;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.annotation.Generated;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import prograavanzada2016.anotherworld.comandos.Comando;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.observer.ILogin;

public class ClienteJugable{
	private int idCliente;
	@Expose(serialize=false)
	private Socket socket;
	@Expose(serialize=false)
	private ClienteManager clienteManager;
	private Usuario usuario;
	@Expose(serialize=false)
	private ArrayList<Usuario> otrosClientes;
	@Expose(serialize=false)
	Gson gson;
	
	public ClienteJugable(String server, int port) throws UnknownHostException, IOException {
		this.otrosClientes=new ArrayList<>();
		this.socket = new Socket(server, port);
		clienteManager = new ClienteManager(this);
		Thread instancia = new Thread(clienteManager);
		gson = new Gson();
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
	
	public String recibirMensaje(){
		return clienteManager.reciveMessage(); //devuelve un MensajeEnviable en forma de json
	}
	
	public void enviarComando(Comando comando){
		clienteManager.sendMensaje(comando.enviarComando());
	}
	
	public void enviarComando(RawMessage rawMessage){
		clienteManager.sendMensaje(gson.toJson(rawMessage));
	}

	public ArrayList<Usuario> getOtrosClientes() {
		return otrosClientes;
	}

	public void setOtrosClientes(ArrayList<Usuario> otrosClientes) {
		this.otrosClientes = otrosClientes;
	}
}
