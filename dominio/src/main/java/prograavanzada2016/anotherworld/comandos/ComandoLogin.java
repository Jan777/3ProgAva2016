package prograavanzada2016.anotherworld.comandos;

import com.google.gson.Gson;

public class ComandoLogin extends Comando{
	private String user;
	private String password;
	
	public ComandoLogin(String user, String password){
		this.gson=new Gson();
		this.user=user;
		this.password=password;
		this.armarMensajeDesdeCliente();
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		this.requestFromClient="1 "+this.user+" "+this.password;
	}

	@Override
	protected void armarMensajeDesdeServidor(String mensajeDeServidor) {
		this.responseFromServer="1 "+mensajeDeServidor;
	}

}
