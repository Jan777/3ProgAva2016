package prograavanzada2016.anotherworld.mensajes.request;

import prograavanzada2016.anotherworld.mensajes.MessageBase;

public class PersonajeConsultaMessage extends MessageBase{
	
	public PersonajeConsultaMessage(String message) {
		this.Payload=message;
	}
	
	@Override
	public void Resolve() throws Exception {
		servicio.ejecutar(this);
		
	}

}
