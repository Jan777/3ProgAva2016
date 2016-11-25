package prograavanzada2016.anotherworld.resources;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogAnother {
	
	private static final Logger LOGGER = Logger.getLogger( LogAnother.class.getName() );
	FileHandler fh;
	private static LogAnother instance;
	
	private LogAnother() throws IOException{
		Propiedades prop = Propiedades.getInstance();
		fh = new FileHandler(prop.getProperty("logger"));
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		LOGGER.addHandler(fh);
	}
	
	public static LogAnother getInstance() throws IOException{
		if(instance == null){
			instance = new LogAnother();
		}
		return instance;
	}
	
	public void log(String logString){
		 LOGGER.log(Level.SEVERE, logString);
	}
	public void log(Exception e){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		LOGGER.log(Level.SEVERE,sw.toString());
	}
}
