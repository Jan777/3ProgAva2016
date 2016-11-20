package prograavanzada2016.anotherworld.servidor;

import java.net.Socket;

import prograavanzada2016.anotherworld.modelos.Usuario;

public class ClienteServicio {
	private Socket socket;
	private int id;
	private Usuario usuario;
	
	public ClienteServicio(){}
	
	public ClienteServicio(Socket socket, int id){
		this.socket=socket;
		this.id=id;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
