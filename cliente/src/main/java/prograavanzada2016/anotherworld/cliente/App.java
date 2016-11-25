package prograavanzada2016.anotherworld.cliente;


import javax.swing.JOptionPane;

import prograavanzada2016.anotherworld.resources.LogAnother;
import prograavanzada2016.anotherworld.resources.Propiedades;

public class App {
	public static void main(String[] args){
		LogAnother logger = null;
		try{
			logger = LogAnother.getInstance();
			Propiedades propiedades = Propiedades.getInstance();
			ClienteJugable cliente = new ClienteJugable(propiedades.getProperty("ip"), Integer.parseInt(propiedades.getProperty("puerto")));
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage()+"Ocurrió un error, para más información"+System.getProperty("line.separator") 
			+" vea el LOG del sistema.", "ERROR", JOptionPane.ERROR_MESSAGE);
			logger.log(e.getMessage());
		}
	}
}
