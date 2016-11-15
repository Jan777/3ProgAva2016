package prograavanzada2016.anotherworld.servicios;


import javax.swing.JOptionPane;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.interfaces.VentanaInicio;
import prograavanzada2016.anotherworld.interfaces.VentanaPrincipal;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.response.LoginMessageResponse;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.servicios.ServicioServer;

public class LoginResponseService implements ServicioServer{
	private VentanaPrincipal ventanaPrincipal;
	private ClienteJugable clienteJugable;
	
	public LoginResponseService(ClienteJugable clienteJugable) {
		this.clienteJugable=clienteJugable;
	}
	
	@Override
	public void ejecutar(MessageBase message) throws Exception {
		
		LoginMessageResponse lm = (LoginMessageResponse) message;
		
		Usuario usuario = new Gson().fromJson(lm.Payload, Usuario.class);
		System.out.println("llegamos");
		//pusimo esto asi por el momento para saber si hay o no hay usuario
		if(!usuario.getNombre().equals("")){
			System.out.println("hay usuario: "+usuario.getNombre()+" "+usuario.getApellido());
			clienteJugable.setUsuario(usuario);
			new VentanaInicio(clienteJugable);
		}
		else{
			ventanaPrincipal = new VentanaPrincipal(clienteJugable);
			JOptionPane.showMessageDialog(ventanaPrincipal, "Datos incorrectos");
		}
			
	}

}
