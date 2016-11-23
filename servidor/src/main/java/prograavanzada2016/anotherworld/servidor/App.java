package prograavanzada2016.anotherworld.servidor;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {
	
	private static final Logger LOGGER = Logger.getLogger( "App Servidor");
	static FileHandler fh;
	
	public static void main(String[] args){
		try{
			fh = new FileHandler("C:\\Users\\lukki\\Desktop\\JuegoProgra\\jrpg\\servidor\\bin\\prograavanzada2016\\anotherworld\\servidor\\Servidor.log");
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
