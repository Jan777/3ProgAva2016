package prograavanzada2016.anotherworld.mensajes.response;

import prograavanzada2016.anotherworld.mensajes.MessageBase;

public class CrearPersonajeNuevoResponseMessage extends MessageBase{
	
	public CrearPersonajeNuevoResponseMessage(String message){
		this.Payload=message;
	}
	
	@Override
	public void Resolve() throws Exception {
		this.servicio.ejecutar(this);
	}

}
