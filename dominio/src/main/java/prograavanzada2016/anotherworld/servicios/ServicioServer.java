package prograavanzada2016.anotherworld.servicios;

import java.net.Socket;

import com.google.gson.JsonSyntaxException;

import prograavanzada2016.anotherworld.mensajes.MessageBase;

public interface ServicioServer {
	public void ejecutar(MessageBase message) throws Exception;
}
