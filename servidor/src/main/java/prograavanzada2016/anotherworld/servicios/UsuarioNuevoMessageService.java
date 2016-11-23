package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.DAO.PersonajeDAO;
import prograavanzada2016.anotherworld.DAO.UsuarioDAO;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.request.UsuarioNuevoMessage;
import prograavanzada2016.anotherworld.mensajes.response.LoginMessageResponse;
import prograavanzada2016.anotherworld.mensajes.response.RespuestaGenericaMessage;
import prograavanzada2016.anotherworld.modelos.RespuestaGenerica;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.servidor.ClienteServicio;
import prograavanzada2016.anotherworld.servidor.Servidor;

public class UsuarioNuevoMessageService implements ServicioServer{

	@Override
	public void ejecutar(MessageBase message) throws Exception {
		UsuarioDAO usuarioDAO = new UsuarioDAO(null, null);
		UsuarioNuevoMessage unm = (UsuarioNuevoMessage) message;
		Usuario usuario = new Gson().fromJson(unm.Payload, Usuario.class);
		
		if(usuarioDAO.insertar(usuario)){
			RespuestaGenerica resp = new RespuestaGenerica(true);
			for(ClienteServicio cliente : Servidor.clientesSala1){
				
				if(cliente.getId() == unm.idCliente){
					PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
					
					RawMessage rawMessageLogin = new RawMessage();
			    	rawMessageLogin.type = "respuestaGenericaNuevoUsuario";
			    	rawMessageLogin.message = new RespuestaGenericaMessage(new Gson().toJson(resp));
					
					salida.println(new Gson().toJson(rawMessageLogin));
					salida.flush();
				}
			}
		}else{
			RespuestaGenerica resp = new RespuestaGenerica(false);
			for(ClienteServicio cliente : Servidor.clientesSala1){
				
				if(cliente.getId() == unm.idCliente){
					PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
					
					RawMessage rawMessageLogin = new RawMessage();
			    	rawMessageLogin.type = "respuestaGenericaNuevoUsuario";
			    	rawMessageLogin.message = new RespuestaGenericaMessage(new Gson().toJson(resp));
					
					salida.println(new Gson().toJson(rawMessageLogin));
					salida.flush();
				}
			}
		}
	}

}
