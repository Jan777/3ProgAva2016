package prograavanzada2016.anotherworld.servicios;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.response.ConsultaColisionResponseMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;

public class ConsultaColisionResponseService implements ServicioServer{
	private ClienteJugable clienteJugable;
	public ConsultaColisionResponseService(ClienteJugable clienteJugable){
		this.clienteJugable=clienteJugable;
	}
	@Override
	public void ejecutar(MessageBase message) throws Exception {
		ConsultaColisionResponseMessage ccrm = (ConsultaColisionResponseMessage) message;
		
		Usuario enemigo = new Gson().fromJson(ccrm.Payload, Usuario.class);
		this.clienteJugable.getJuego().quitarEnemigoEnBatalla(enemigo);
	}

}
