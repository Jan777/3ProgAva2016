package prograavanzada2016.anotherworld.servicios;

import java.util.HashMap;

import prograavanzada2016.anotherworld.mensajes.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.MessageDeserializer;
import prograavanzada2016.anotherworld.servicios.ServicioServer;

public class ServiceLocator {
	
	public static ServicioServer localizar(String tipo) {
		// TODO aca tiene que haber una forma de mapear tipo con clase correspondiente
		if(tipo.equals("login")){
			return new LoginService();
		}else if(tipo.equals("personajeConsulta")){
			return new PersonajeConsultaService();
		}else if(tipo.equals("usuarioNuevo")){
			return new UsuarioNuevoMessageService();
		}
		return null;
	}
}
