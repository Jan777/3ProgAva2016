package prograavanzada2016.anotherworld.servicios;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.mensajes.MessageBase;

public class ConsultaColisionResponseService implements ServicioServer{
	private ClienteJugable clienteJugable;
	public ConsultaColisionResponseService(ClienteJugable clienteJugable){
		this.clienteJugable=clienteJugable;
	}
	@Override
	public void ejecutar(MessageBase message) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
