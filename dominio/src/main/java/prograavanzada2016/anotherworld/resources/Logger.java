package prograavanzada2016.anotherworld.resources;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	private static Logger instance;
	private PrintWriter file;
	private Logger() throws IOException{		
		 file = new PrintWriter(new File("src\\main\\resources\\logger.log"));
	}
	
	public static Logger getInstance() throws IOException{
		if(instance == null){
			instance = new Logger();
		}
		return instance;
	}
	
	public void log(String logString){
		 file.println(logString);
	}
}
