package prograavanzada2016.anotherworld.mensajes.response;

import prograavanzada2016.anotherworld.mensajes.MessageBase;

public class MoverResponseMessage extends MessageBase{
	
	public MoverResponseMessage(String message) {
		this.Payload=message;
	}
	
	@Override
	public void Resolve() throws Exception {
		servicio.ejecutar(this);
	}

}
