package prograavanzada2016.anotherworld.mensajes;

public class PersonajeNuevoConectadoMessage extends MessageBase{
	public PersonajeNuevoConectadoMessage(String message) {
		this.Payload=message;
	}
	@Override
	public void Resolve() throws Exception {
		servicio.ejecutar(this);
	}

}
