package prograavanzada2016.anotherworld.cliente;

import java.io.FileInputStream;
import java.util.Properties;

import prograavanzada2016.anotherworld.interfaces.VentanaMapa;

public class App {
	public static void main(String[] args) throws Exception{
		Properties propiedades = new Properties();
		propiedades.load(new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\resources\\cfg.properties"));
		ClienteJugable cliente = new ClienteJugable(propiedades.getProperty("ip"), Integer.parseInt(propiedades.getProperty("puerto")));
	}
}
