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
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.servicios.ServicioServer;
import prograavanzada2016.anotherworld.servidor.ClienteServicio;
import prograavanzada2016.anotherworld.servidor.Servidor;

public class LoginService implements ServicioServer{

	@Override
	public void ejecutar(MessageBase message) throws Exception {
		UsuarioDAO usuarioDAO = new UsuarioDAO(null, null);
		LoginMessage lm = (LoginMessage) message;
		Usuario usuario = new Gson().fromJson(lm.Payload, Usuario.class);
		System.out.println("antes de entrar");
		//el 1==1 lo hacemos para que siempre vaya ahi aunque no lo encuentre
		//la logica de saber si llego o no esta en el cliente
		//deberiamos modificar esto pero no tenemos tiempo
		if(usuarioDAO.buscar(usuario) == 1 || 1==1){
			System.out.println("enrttamos");
			for(ClienteServicio cliente : Servidor.clientesSala1){
					
					if(cliente.getId() == lm.idCliente){
						System.out.println("encontrado");
						PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
						
						RawMessage rawMessageLogin = new RawMessage();
				    	rawMessageLogin.type = "loginResponse";
				    	rawMessageLogin.message = new LoginMessageResponse(new Gson().toJson(usuario));
						
						salida.println(new Gson().toJson(rawMessageLogin));
						salida.flush();
					}
			}
		}
	//	}else{
			
	//	}
		// TODO Auto-generated method stub
		// lalala
		
		//sockets.broadcast(new Mensaje());
	}


}
