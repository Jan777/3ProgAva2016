package prograavanzada2016.anotherworld.cliente;

import prograavanzada2016.anotherworld.comandos.ComandoLogin;
import prograavanzada2016.anotherworld.interfaces.VentanaPrincipal;

public class App {
	public static void main(String[] args) throws Exception{
		ClienteJugable cliente = new ClienteJugable("localhost",444,"pepe","1234");
		Thread.sleep(2000);
		cliente.enviarComando(new ComandoLogin("pepe", "12345"));
		//VentanaPrincipal ventana =  new VentanaPrincipal();
		//ventana.setVisible(true);
		
		//cliente.enviarMensaje("holaaaaaaaaaa");
	}
}
