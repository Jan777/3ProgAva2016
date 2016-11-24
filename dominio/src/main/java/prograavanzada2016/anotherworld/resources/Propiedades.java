package prograavanzada2016.anotherworld.resources;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Propiedades {
	private static Propiedades instance;
	private Properties propiedades;
	private Propiedades() throws IOException{		
		propiedades = new Properties();
		propiedades.load(new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("cfg.properties"))));
		//propiedades.load(new FileInputStream("src\\main\\resources\\cfg.properties"));
	}
	
	public static Propiedades getInstance() throws IOException{
		if(instance == null){
			instance = new Propiedades();
		}
		return instance;
	}
	
	public String getProperty(String key){
		return propiedades.getProperty(key);
	}
}
