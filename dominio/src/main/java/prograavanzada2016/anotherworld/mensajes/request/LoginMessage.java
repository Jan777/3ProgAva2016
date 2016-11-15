package prograavanzada2016.anotherworld.mensajes.request;

import prograavanzada2016.anotherworld.mensajes.MessageBase;

public class LoginMessage extends MessageBase {
	
	
	public LoginMessage(String message){
		this.Payload=message;
		this.esBroadcast=false;
	}
	
	
	
	@Override
	public void Resolve() throws Exception{
		servicio.ejecutar(this);
		//System.out.println("Login ok Grande Sombra!!");
	}
}
