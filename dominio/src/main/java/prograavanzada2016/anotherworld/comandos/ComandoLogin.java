package prograavanzada2016.anotherworld.comandos;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ComandoLogin extends Comando{
	private String user;
	private String password;
	
	public ComandoLogin(String user, String password) throws Exception{
		this.user=user;
		this.password=password;
		this.armarMensajeDesdeCliente();
	}
	
	public ComandoLogin(){}
	
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
		Gson gson = new Gson();
		System.out.println(gson.toJson(this));
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
	protected void armarMensajeDesdeCliente(){
		this.requestFromClient="1 "+this.user+" "+this.password;
	}

	@Override
	public void armarMensajeDesdeServidor(String mensajeDeServidor) {
		this.responseFromServer="1 "+mensajeDeServidor;
	}

}
