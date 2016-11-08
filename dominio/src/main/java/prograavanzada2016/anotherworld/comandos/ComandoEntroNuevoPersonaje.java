package prograavanzada2016.anotherworld.comandos;

import prograavanzada2016.anotherworld.entities.Personaje;

public class ComandoEntroNuevoPersonaje extends Comando{
	private int clienteId;
	private Personaje personaje;
	
	public ComandoEntroNuevoPersonaje(int clienteId, Personaje personaje) {
		this.clienteId=clienteId;
		this.personaje=personaje;
		this.armarMensajeDesdeServidor("2 "+clienteId+" "+gson.toJson(personaje));
	}

	@Override
	public String enviarComando() {
		return gson.toJson(this);
	}

	@Override
	public String recibirComandoCliente() {
		return this.responseFromServer;
	}

	@Override
	public String recibirComandoServidor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void armarMensajeDesdeCliente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void armarMensajeDesdeServidor(String mensajeDeServidor) {
		this.responseFromServer=mensajeDeServidor;
	}

}
