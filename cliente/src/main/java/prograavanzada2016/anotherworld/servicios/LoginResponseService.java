package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import prograavanzada2016.anotherworld.DAO.DAOException;
import prograavanzada2016.anotherworld.DAO.UsuarioDAO;
import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.interfaces.VentanaInicio;
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
	private ClienteJugable clienteJugable;
	
	public LoginResponseService(ClienteJugable clienteJugable) {
		this.clienteJugable=clienteJugable;
	}
	
	@Override
	public void ejecutar(MessageBase message) throws Exception {
		
		LoginMessageResponse lm = (LoginMessageResponse) message;
		
		Usuario usuario = new Gson().fromJson(lm.Payload, Usuario.class);
		
		
		if(usuario!=null){
			clienteJugable.setUsuario(usuario);
			ventanaInicio = new VentanaInicio(clienteJugable);
		}
		else
			System.out.println("Error");
		
		if(lm.Payload.equals("OK")){
			
		}	
	}

}
