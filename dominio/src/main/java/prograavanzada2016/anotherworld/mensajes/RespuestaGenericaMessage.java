package prograavanzada2016.anotherworld.mensajes;

public class RespuestaGenericaMessage extends MessageBase{
	
	public RespuestaGenericaMessage(String message){
		this.Payload=message;
	}
	
	@Override
	public void Resolve() throws Exception {
		this.servicio.ejecutar(this);		
	}

}
