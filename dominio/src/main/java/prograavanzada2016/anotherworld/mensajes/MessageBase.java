package prograavanzada2016.anotherworld.mensajes;

public class MessageBase {
	protected String Payload;
	
	public void Resolve(){
		
	}
}


class DisconnectMessage extends MessageBase {
	@Override
	public void Resolve(){
		System.out.println("Disconnected");
	}
}