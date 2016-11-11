package prograavanzada2016.anotherworld.comandos;

import com.google.gson.Gson;

public class Comando {
	protected int codigo;
	protected String mensaje;
	protected String responseFromServer;
	protected String requestFromClient;
	
	public Comando(int codigo, String mensaje, Gson gson, String responseFromServer, String requestFromClient) {
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.responseFromServer = responseFromServer;
		this.requestFromClient = requestFromClient;
	}
	
	public Comando(){}
	
	/**
	 * Metodo para enviar cualquier comando a traves del socket
	 * **/
	public String enviarComando(){
		return mensaje;}
	/**
	 * Metodo para recibir la respuesta del servidor
	 * **/
	public String recibirComandoCliente(){
		return mensaje;}
	/**
	 * Metodo para recibir la respuesta del cliente
	 * **/
	public String recibirComandoServidor(){
		return mensaje;}
	/**
	 * Metodo para armar la respuesta del cliente
	 * **/
	protected void armarMensajeDesdeCliente(){};
	/**
	 * Metodo para armar la respuesta del servidor
	 * **/
	protected void armarMensajeDesdeServidor(String mensajeDeServidor){};
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getResponseFromServer() {
		return responseFromServer;
	}
	public void setResponseFromServer(String responseFromServer) {
		this.responseFromServer = responseFromServer;
	}
	public String getRequestFromClient() {
		return requestFromClient;
	}
	public void setRequestFromClient(String requestFromClient) {
		this.requestFromClient = requestFromClient;
	}
}
