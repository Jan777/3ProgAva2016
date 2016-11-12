package prograavanzada2016.anotherworld.servicios;

import prograavanzada2016.anotherworld.servicios.ServicioServer;

public class ServiceLocator {
	
	public static ServicioServer localizar(String tipo) {
		// TODO aca tiene que haber una forma de mapear tipo con clase correspondiente
		return new LoginService();
	}

}
