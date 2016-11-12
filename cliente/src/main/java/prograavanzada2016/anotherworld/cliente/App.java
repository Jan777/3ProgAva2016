package prograavanzada2016.anotherworld.cliente;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.mensajes.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.user.Usuario;

public class App {
	public static void main(String[] args) throws Exception{
		ClienteJugable cliente = new ClienteJugable("localhost",444);
		Thread.sleep(2000);
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("Luki");
		usuario.setPassword("123");
		RawMessage rawMessageLogin = new RawMessage();
    	rawMessageLogin.type = "login";
    	rawMessageLogin.message = new LoginMessage(new Gson().toJson(usuario));
		
		//cliente.enviarComando(new ComandoLogin("pepe", "12345"));
		
		// String jsonLogin = new Gson().toJson(rawMessageLogin);
		 
		 cliente.enviarComando(rawMessageLogin);
		 
		//VentanaPrincipal ventana =  new VentanaPrincipal();
		//ventana.setVisible(true);
		
		//cliente.enviarMensaje("holaaaaaaaaaa");
	}
}
