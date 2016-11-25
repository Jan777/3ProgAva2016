package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.interfaces.VentanaCrearPersonaje;
import prograavanzada2016.anotherworld.juego.Game;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.EnemigoConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.response.PersonajeConsultaResponseMessage;
import prograavanzada2016.anotherworld.mensajes.response.RecibirPersonajesConectadosMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;

public class RecibirPersonajesConectadosService implements ServicioServer{
	
	private ClienteJugable clienteJugable;
	
	public RecibirPersonajesConectadosService(ClienteJugable clienteJugable){
		this.clienteJugable=clienteJugable;
	}
	
	@Override
	public void ejecutar(MessageBase message) throws Exception {
		RecibirPersonajesConectadosMessage pcm = (RecibirPersonajesConectadosMessage) message;
		
		Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();

		List<Usuario> usuarios = new Gson().fromJson(pcm.Payload, listType);
		for(Usuario usuarioOtro : usuarios){
			this.clienteJugable.getOtrosClientes().add(usuarioOtro);
			this.clienteJugable.getJuego().agregarNuevoPersonaje(usuarioOtro);
		}
		
		PrintWriter salida = new PrintWriter(this.clienteJugable.getSocket().getOutputStream());
		
		RawMessage rawMessageLogin = new RawMessage();
    	rawMessageLogin.type = "buscarEnemigos";
    	rawMessageLogin.message = new EnemigoConsultaMessage(new Gson().toJson(clienteJugable.getUsuario()));
		
		salida.println(new Gson().toJson(rawMessageLogin));
		salida.flush();
	}
	
}
