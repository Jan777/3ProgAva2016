package prograavanzada2016.anotherworld.servidor;

public class App {
	public static void main(String[] args){
		try{
			Servidor server = new Servidor();
			server.iniciarServidor();
		}
		catch(Exception e){
			System.out.print("Ocurri� un error, para m�s informaci�n vea el LOG del sistema.");
		}
		
	}
	
}
