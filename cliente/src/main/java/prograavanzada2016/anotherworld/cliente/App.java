package prograavanzada2016.anotherworld.cliente;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import prograavanzada2016.anotherworld.interfaces.VentanaMapa;

public class App {
	
	private static final Logger LOGGER = Logger.getLogger( "App Cliente");
	static FileHandler fh;
	
	public static void main(String[] args){
		Properties propiedades = new Properties();
		try{
			fh = new FileHandler("C:\\Users\\lukki\\Desktop\\JuegoProgra\\jrpg\\cliente\\src\\main\\java\\prograavanzada2016\\anotherworld\\cliente\\Cliente.log");
			LOGGER.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);
			propiedades.load(new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\resources\\cfg.properties"));
			ClienteJugable cliente = new ClienteJugable(propiedades.getProperty("ip"), Integer.parseInt(propiedades.getProperty("puerto")));
			
		}
		catch(Exception e){
			System.out.print("Ocurrió un error, para más información vea el LOG del sistema.");
			LOGGER.info("No se pudo iniciar el cliente, verifique archivo de propiedades");
		}
		
	}
}


//throws Exception