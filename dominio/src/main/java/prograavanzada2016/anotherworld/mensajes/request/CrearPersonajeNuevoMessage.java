package prograavanzada2016.anotherworld.mensajes.request;

import prograavanzada2016.anotherworld.mensajes.MessageBase;

public class CrearPersonajeNuevoMessage extends MessageBase{
	
	public CrearPersonajeNuevoMessage(String message){
		this.Payload=message;
	}
	
	@Override
	public void Resolve() throws Exception {
		servicio.ejecutar(this);
	}

}
