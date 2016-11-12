package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import prograavanzada2016.anotherworld.DAO.DAOException;
import prograavanzada2016.anotherworld.DAO.UsuarioDAO;
import prograavanzada2016.anotherworld.mensajes.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.LoginMessageResponse;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.servicios.ServicioServer;
import prograavanzada2016.anotherworld.servidor.ClienteServicio;
import prograavanzada2016.anotherworld.servidor.Servidor;
import prograavanzada2016.anotherworld.user.Usuario;

public class LoginService implements ServicioServer{

	@Override
	public void ejecutar(MessageBase message) throws Exception {
		UsuarioDAO usuarioDAO = new UsuarioDAO(null, null);
		LoginMessage lm = (LoginMessage) message;
		Usuario user = new Gson().fromJson(lm.Payload, Usuario.class);
		System.out.println("antes de entrar");
		if(usuarioDAO.buscar(user) == 1){
			System.out.println("enrttamos");
			for(ClienteServicio cliente : Servidor.clientesSala1){
				
				if(cliente.getId() == lm.idCliente){
					System.out.println("encontrado");
					PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
					
					RawMessage rawMessageLogin = new RawMessage();
			    	rawMessageLogin.type = "loginRespuesta";
			    	rawMessageLogin.message = new LoginMessageResponse(new Gson().toJson(user));
					
					salida.println(rawMessageLogin);
					salida.flush();
				}
			}
		}
		// TODO Auto-generated method stub
		// lalala
		
		//sockets.broadcast(new Mensaje());
	}


}
