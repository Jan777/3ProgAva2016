package otraPrueba;
import java.io.*;
import java.util.*;

public class Propiedades
{
	private static Propiedades instance = new Propiedades();
	private String ip;
	private int puerto;
	
	private Propiedades()
	{
		String archivoPropiedades = "config.properties";
		Properties prop = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(archivoPropiedades);
		
		try 
		{
			if (inputStream != null)
				prop.load(inputStream);
			else
				throw new FileNotFoundException("Archivo de propiedades '" + archivoPropiedades + "' no encontrado.");
 
			this.ip = prop.getProperty("ip");
			this.puerto = Integer.parseInt(prop.getProperty("puerto"));
		} 
		catch (Exception e)
		{
			System.out.println("Exception: " + e);
		} 
		finally 
		{
			try 
			{
				inputStream.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static Propiedades getInstance()
	{
		return instance;
	}

	public String getIp() 
	{
		return this.ip;
	}

	public int getPuerto() 
	{
		return this.puerto;
	}
}