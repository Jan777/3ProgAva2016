package prograavanzada2016.anotherworld.servidor;

import java.net.Socket;

public class ClienteServicio {
	private Socket socket;
	private int id;
	
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
	
	
}
