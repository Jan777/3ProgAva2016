package prograavanzada2016.anotherworld.mensajes;

public class PersonajeConsultaResponseMessage extends MessageBase{
	
	public PersonajeConsultaResponseMessage(String message) {
		this.Payload=message;
	}
	
	@Override
	public void Resolve() throws Exception {
		servicio.ejecutar(this);
	}
	

}
