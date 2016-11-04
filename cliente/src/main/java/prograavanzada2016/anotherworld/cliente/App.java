package prograavanzada2016.anotherworld.cliente;

public class App {
	public static void main(String[] args) throws Exception{
		Cliente cliente = new Cliente();
		Thread.sleep(2000);
		cliente.enviarMensaje("holaaaaaaaaaa");
	}
}
