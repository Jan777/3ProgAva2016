package prograavanzada2016.anotherworld.servidor;

import java.sql.DriverManager;
/*import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;*/

import javax.swing.JOptionPane;

import prograavanzada2016.anotherworld.resources.Logger;
import prograavanzada2016.anotherworld.resources.Propiedades;

public class App {
	
	//private static final Logger LOGGER = Logger.getLogger( "App Servidor");
	//static FileHandler fh;
	
	public static void main(String[] args){
		Logger logger = null;
		try{
			Propiedades propiedades = Propiedades.getInstance();
			logger = Logger.getInstance();
			/*fh = new FileHandler(propiedades.getProperty("logger"));
			LOGGER.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);*/
			Servidor server = new Servidor();
			server.iniciarServidor();
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Ocurri� un error, para m�s informaci�n"+System.getProperty("line.separator") 
			+" vea el LOG del sistema.", "ERROR", JOptionPane.ERROR_MESSAGE);
			//System.out.print("Ocurri� un error, para m�s informaci�n vea el LOG del sistema.");
			logger.log(e.getMessage());
			//LOGGER.info("No se pudo iniciar el servidor, por favor verificar si el puerto se encuentra disponible");
		}
		
	}
	
}
