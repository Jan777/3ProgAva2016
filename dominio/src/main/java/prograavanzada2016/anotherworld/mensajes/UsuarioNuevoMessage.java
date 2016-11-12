package prograavanzada2016.anotherworld.mensajes;

public class UsuarioNuevoMessage extends MessageBase{
	
	public UsuarioNuevoMessage(String message){
		this.Payload=message;
	}
	
	@Override
	public void Resolve() throws Exception {
		this.servicio.ejecutar(this);
	}

}
