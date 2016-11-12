package prograavanzada2016.anotherworld.servicios;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.servicios.ServicioServer;

public class ServiceLocator {
	
	public static ServicioServer localizar(String tipo,ClienteJugable clienteJugable) {
		if(tipo.equals("loginResponse")){
			return new LoginResponseService(clienteJugable);
		}
		return null;
	}

}
