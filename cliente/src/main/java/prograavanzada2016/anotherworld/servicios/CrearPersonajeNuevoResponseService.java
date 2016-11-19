package prograavanzada2016.anotherworld.servicios;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.juego.Game;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.response.CrearPersonajeNuevoResponseMessage;
import prograavanzada2016.anotherworld.modelos.PersonajeModel;

public class CrearPersonajeNuevoResponseService implements ServicioServer{
	private ClienteJugable clienteJugable;
	CrearPersonajeNuevoResponseService(ClienteJugable clienteJugable){
		this.clienteJugable = clienteJugable;
	}
	@Override
	public void ejecutar(MessageBase message) throws Exception {

		CrearPersonajeNuevoResponseMessage cpnrm = (CrearPersonajeNuevoResponseMessage) message;
		
		PersonajeModel personajeModel = new Gson().fromJson(cpnrm.Payload, PersonajeModel.class);
		
		System.out.println("nuevo personaje aliado: "+personajeModel.getNombre());
		
		//Game game = new Game("Another World", 800, 600);
		//game.start();
	}

}
