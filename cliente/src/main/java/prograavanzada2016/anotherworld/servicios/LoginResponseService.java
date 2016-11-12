package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import prograavanzada2016.anotherworld.DAO.DAOException;
import prograavanzada2016.anotherworld.DAO.UsuarioDAO;
import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.interfaces.VentanaInicio;
import prograavanzada2016.anotherworld.interfaces.VentanaPrincipal;
import prograavanzada2016.anotherworld.mensajes.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.LoginMessageResponse;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.observer.ILogin;
import prograavanzada2016.anotherworld.observer.SubjectLogin;
import prograavanzada2016.anotherworld.servicios.ServicioServer;
import prograavanzada2016.anotherworld.servidor.ClienteServicio;
import prograavanzada2016.anotherworld.servidor.Servidor;
import prograavanzada2016.anotherworld.user.Usuario;

public class LoginResponseService implements ServicioServer{
	private VentanaInicio ventanaInicio;
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
			ventanaInicio = new VentanaInicio(clienteJugable);
		}
		else{
			ventanaPrincipal = new VentanaPrincipal(clienteJugable);
			JOptionPane.showMessageDialog(ventanaPrincipal, "Datos incorrectos");
		}
			
	}

}
