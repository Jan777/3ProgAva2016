package prograavanzada2016.anotherworld.mensajes.request;

import prograavanzada2016.anotherworld.mensajes.MessageBase;

public class EnemigoConsultaMessage extends MessageBase{
	public EnemigoConsultaMessage(String message) {
		this.Payload=message;
	}
	@Override
	public void Resolve() throws Exception {
		this.servicio.ejecutar(this);
	}

}
