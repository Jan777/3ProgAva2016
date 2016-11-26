package prograavanzada2016.anotherworld.mensajes;

import java.net.Socket;

import prograavanzada2016.anotherworld.servicios.ServicioServer;

public abstract class MessageBase {
	public String Payload;
	public boolean esBroadcast = false;
	public ServicioServer servicio;
	public int idCliente;
	public abstract void Resolve() throws Exception;
}


class DisconnectMessage extends MessageBase {
	@Override
	public void Resolve(){
		//System.out.println("Disconnected");
	}
}