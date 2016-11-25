package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.EnemigoConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.response.EnviarEnemigosResponseMessage;
import prograavanzada2016.anotherworld.mensajes.response.RecibirPersonajesConectadosMessage;
import prograavanzada2016.anotherworld.modelos.InteligenciaArtificial;
import prograavanzada2016.anotherworld.modelos.Usuario;

public class EnemigoConsultaResponseService implements ServicioServer{
	private ClienteJugable clienteJugable;
	public EnemigoConsultaResponseService(ClienteJugable clienteJugable){
		this.clienteJugable=clienteJugable;
	}

	@Override
	public void ejecutar(MessageBase message) throws Exception {
		EnviarEnemigosResponseMessage eerm = (EnviarEnemigosResponseMessage) message;
		
		Type listType = new TypeToken<ArrayList<InteligenciaArtificial>>(){}.getType();

		List<InteligenciaArtificial> enemigos = new Gson().fromJson(eerm.Payload, listType);
		for(InteligenciaArtificial enemigo : enemigos){
			Thread.sleep(5000);
			this.clienteJugable.getEnemigos().add(enemigo);
			System.out.println("se agrego un nuevo enemigo");
			this.clienteJugable.getJuego().agregarNuevoEnemigo(enemigo);
		}
		
	}

}
