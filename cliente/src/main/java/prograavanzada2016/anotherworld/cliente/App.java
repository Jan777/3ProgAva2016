package prograavanzada2016.anotherworld.cliente;

import javax.swing.JOptionPane;

import prograavanzada2016.anotherworld.resources.Logger;
import prograavanzada2016.anotherworld.resources.Propiedades;

public class App {
	
	public static void main(String[] args){
		Logger logger = null;
		try{
			Propiedades propiedades = Propiedades.getInstance();
			logger = Logger.getInstance();
			ClienteJugable cliente = new ClienteJugable(propiedades.getProperty("ip"), Integer.parseInt(propiedades.getProperty("puerto")));
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Ocurrió un error, para más información"+System.getProperty("line.separator") 
			+" vea el LOG del sistema.", "ERROR", JOptionPane.ERROR_MESSAGE);
			logger.log(e.getMessage());
		}
		//VentanaCombatePvE frame = new VentanaCombatePvE();
        //frame.setVisible(true);
        //frame.setLocationRelativeTo(null);
		
	}
}
