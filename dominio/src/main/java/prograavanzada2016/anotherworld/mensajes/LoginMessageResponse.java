package prograavanzada2016.anotherworld.mensajes;

public class LoginMessageResponse extends MessageBase{
	
	public LoginMessageResponse(String message){
		this.Payload=message;
	}
	
	@Override
	public void Resolve() throws Exception {
		servicio.ejecutar(this);
	}
}
