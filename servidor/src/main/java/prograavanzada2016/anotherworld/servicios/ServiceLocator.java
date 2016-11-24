package prograavanzada2016.anotherworld.servicios;

import java.util.HashMap;

import prograavanzada2016.anotherworld.mensajes.MessageDeserializer;
import prograavanzada2016.anotherworld.mensajes.request.LoginMessage;
import prograavanzada2016.anotherworld.servicios.ServicioServer;

public class ServiceLocator {
	
	public static ServicioServer localizar(String tipo) throws Exception{
		// TODO aca tiene que haber una forma de mapear tipo con clase correspondiente
		if(tipo.equals("login")){
			return new LoginService();
		}else if(tipo.equals("personajeConsulta")){
			return new PersonajeConsultaService();
		}else if(tipo.equals("usuarioNuevo")){
			return new UsuarioNuevoMessageService();
		}else if(tipo.equals("crearPersonaje")){
			return new CrearPersonajeNuevoService();
		}else if(tipo.equals("moverPersonaje")){
			return new MoverService();
		}else if(tipo.equals("buscarPersonajes")){
			return new BuscarPersonajesService();
		}else if(tipo.equals("buscarEnemigos")){
			return new EnemigoConsultaService();
		}else if(tipo.equals("consultaColision")){
			return new ConsultaColisionService();
		}
		return null;
	}
}
