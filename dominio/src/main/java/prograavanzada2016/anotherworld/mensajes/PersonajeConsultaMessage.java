package prograavanzada2016.anotherworld.mensajes;

public class PersonajeConsultaMessage extends MessageBase{
	
	public PersonajeConsultaMessage(String message) {
		this.Payload=message;
	}
	
	@Override
	public void Resolve() throws Exception {
		servicio.ejecutar(this);
		
	}

}
