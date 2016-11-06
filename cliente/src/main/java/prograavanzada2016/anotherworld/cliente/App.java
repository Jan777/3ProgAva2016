package prograavanzada2016.anotherworld.cliente;

import prograavanzada2016.anotherworld.interfaces.VentanaPrincipal;

public class App {
	public static void main(String[] args) throws Exception{
		Cliente cliente = new Cliente();
		Thread.sleep(2000);
		
		VentanaPrincipal ventana =  new VentanaPrincipal();
		ventana.setVisible(true);
		
		//cliente.enviarMensaje("holaaaaaaaaaa");
	}
}
