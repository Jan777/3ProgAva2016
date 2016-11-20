package prograavanzada2016.anotherworld.servicios;


import javax.swing.JOptionPane;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.interfaces.VentanaDeBienvenida;
import prograavanzada2016.anotherworld.interfaces.VentanaLogin;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.response.LoginMessageResponse;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.servicios.ServicioServer;

public class LoginResponseService implements ServicioServer{
	private VentanaLogin ventanaPrincipal;
	private ClienteJugable clienteJugable;
	
	public LoginResponseService(ClienteJugable clienteJugable) {
		this.clienteJugable=clienteJugable;
	}
	
	@Override
	public void ejecutar(MessageBase message) throws Exception {
		
		LoginMessageResponse lm = (LoginMessageResponse) message;
		
		Usuario usuario = new Gson().fromJson(lm.Payload, Usuario.class);
		if(!usuario.getNombre().equals("")){
			usuario.setClienteId(this.clienteJugable.getIdCliente());
			clienteJugable.setUsuario(usuario);
			new VentanaDeBienvenida(clienteJugable);
		}
		else{
			ventanaPrincipal = new VentanaLogin(clienteJugable);
			JOptionPane.showMessageDialog(ventanaPrincipal, "Datos incorrectos");
		}
			
	}

}
