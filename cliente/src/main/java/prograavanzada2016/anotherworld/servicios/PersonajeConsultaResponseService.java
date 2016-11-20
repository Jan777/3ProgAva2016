package prograavanzada2016.anotherworld.servicios;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.interfaces.VentanaCrearPersonaje;
import prograavanzada2016.anotherworld.interfaces.VentanaDeBienvenida;
import prograavanzada2016.anotherworld.juego.Game;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeNuevoConectadoMessage;
import prograavanzada2016.anotherworld.mensajes.response.PersonajeConsultaResponseMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;

public class PersonajeConsultaResponseService implements ServicioServer{
	
	

	private ClienteJugable clienteJugable;
	
	public PersonajeConsultaResponseService(ClienteJugable clienteJugable) {
		this.clienteJugable=clienteJugable;
	}
	
	@Override
	public void ejecutar(MessageBase message) throws Exception {
		PersonajeConsultaResponseMessage pcm = (PersonajeConsultaResponseMessage) message;
		
		Usuario usuario = new Gson().fromJson(pcm.Payload, Usuario.class);
		//pusimo esto asi por el momento para saber si hay o no hay usuario
		this.clienteJugable.setUsuario(usuario);
		if(usuario.getPersonaje()==null){
			// es nuevo
			System.out.println("hay usuario: "+usuario.getNombre()+" "+usuario.getApellido());
			
			new VentanaCrearPersonaje(this.clienteJugable);
		}
		else{
			//ventanaPrincipal = new VentanaPrincipal(clienteJugable);
			//JOptionPane.showMessageDialog(ventanaPrincipal, "Datos incorrectos");
			System.out.println("tiene un personaje");
			
			Game game = new Game("Another World", 800, 600, clienteJugable);
			
			clienteJugable.setJuego(game);
			
			game.start();
		}
		
	}


}
