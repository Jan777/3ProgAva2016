package prograavanzada2016.anotherworld.comandos;

public class ComandoMover extends Comando{
	private int clienteId;
	private int posX;
	private int posY;
	
	public ComandoMover(int clienteId, int posX, int posY) {
		this.clienteId = clienteId;
		this.posX = posX;
		this.posY = posY;
		this.armarMensajeDesdeCliente();
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
		return this.requestFromClient;
	}

	@Override
	protected void armarMensajeDesdeCliente() {
		this.requestFromClient="5 "+this.clienteId+" "+this.posX+" "+this.posY;
	}

	@Override
	protected void armarMensajeDesdeServidor(String mensajeDeServidor) {
		this.responseFromServer="5 "+mensajeDeServidor;
	}

}
