package prograavanzada2016.anotherworld.servidor;

import java.sql.DriverManager;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import prograavanzada2016.anotherworld.resources.Propiedades;

public class App {
	
	private static final Logger LOGGER = Logger.getLogger( "App Servidor");
	static FileHandler fh;
	
	public static void main(String[] args){
		try{
			Propiedades propiedades = Propiedades.getInstance();
			fh = new FileHandler(propiedades.getProperty("logger"));
			LOGGER.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);
			Servidor server = new Servidor();
			server.iniciarServidor();
			
		}
		catch(Exception e){
			System.out.print("Ocurrió un error, para más información vea el LOG del sistema.");
			LOGGER.info("No se pudo iniciar el servidor, por favor verificar si el puerto se encuentra disponible");
		}
		
	}
	
}
