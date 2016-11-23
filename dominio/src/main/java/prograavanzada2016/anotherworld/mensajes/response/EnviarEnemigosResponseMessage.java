package prograavanzada2016.anotherworld.mensajes.response;

import prograavanzada2016.anotherworld.mensajes.MessageBase;

public class EnviarEnemigosResponseMessage extends MessageBase{
	public EnviarEnemigosResponseMessage(String message){
		this.Payload=message;
	}
	@Override
	public void Resolve() throws Exception {
		this.servicio.ejecutar(this);		
	}
	
}
