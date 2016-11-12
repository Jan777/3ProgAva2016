package prograavanzada2016.anotherworld.servicios;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.interfaces.VentanaCrearPersonaje;
import prograavanzada2016.anotherworld.interfaces.VentanaInicio;
import prograavanzada2016.anotherworld.interfaces.VentanaPrincipal;
import prograavanzada2016.anotherworld.mensajes.LoginMessageResponse;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.PersonajeConsultaResponseMessage;
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
		System.out.println("llegamos");
		//pusimo esto asi por el momento para saber si hay o no hay usuario
		if(usuario.getPersonaje()==null){
			// es nuevo
			System.out.println("hay usuario: "+usuario.getNombre()+" "+usuario.getApellido());
			this.clienteJugable.setUsuario(usuario);
			new VentanaCrearPersonaje(this.clienteJugable);
		}
		else{
			//ventanaPrincipal = new VentanaPrincipal(clienteJugable);
			//JOptionPane.showMessageDialog(ventanaPrincipal, "Datos incorrectos");
			System.out.println("tiene un personaje");
		}
		
	}

}
