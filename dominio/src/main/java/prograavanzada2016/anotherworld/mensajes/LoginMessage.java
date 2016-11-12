package prograavanzada2016.anotherworld.mensajes;


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
