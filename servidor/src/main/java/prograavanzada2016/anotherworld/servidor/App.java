package prograavanzada2016.anotherworld.servidor;


import javax.swing.JOptionPane;

import prograavanzada2016.anotherworld.resources.LogAnother;

public class App {

	
	public static void main(String[] args){
		LogAnother logger = null;
		try{
			logger = LogAnother.getInstance();
			Servidor server = new Servidor();
			server.iniciarServidor();
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, " Ocurrió un error, para más información"+System.getProperty("line.separator") 
			+" vea el LOG del sistema.", "ERROR", JOptionPane.ERROR_MESSAGE);
			logger.log(e);
		}
		
	}
	
}
