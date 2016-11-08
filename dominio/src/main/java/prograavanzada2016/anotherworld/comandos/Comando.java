package prograavanzada2016.anotherworld.comandos;

import com.google.gson.Gson;

public abstract class Comando {
	protected int codigo;
	protected String mensaje;
	protected Gson gson;
	protected String responseFromServer;
	protected String requestFromClient;
	
	public abstract String enviarComando();
	public abstract String recibirComandoCliente();
	public abstract String recibirComandoServidor();
	protected abstract void armarMensajeDesdeCliente();
	protected abstract void armarMensajeDesdeServidor(String mensajeDeServidor);
}
