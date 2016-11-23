package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.DAO.PersonajeDAO;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.EnemigoConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeNuevoConectadoMessage;
import prograavanzada2016.anotherworld.mensajes.response.EnviarEnemigosResponseMessage;
import prograavanzada2016.anotherworld.mensajes.response.PersonajeConsultaResponseMessage;
import prograavanzada2016.anotherworld.modelos.PersonajeModel;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.servidor.ClienteServicio;
import prograavanzada2016.anotherworld.servidor.Servidor;

public class EnemigoConsultaService implements ServicioServer{

	@Override
	public void ejecutar(MessageBase message) throws Exception {
		EnemigoConsultaMessage ecm = (EnemigoConsultaMessage)message; 
		Usuario usuario = new Gson().fromJson(ecm.Payload, Usuario.class);

		for(ClienteServicio cliente : Servidor.clientesSala1){
				if(cliente.getId() == ecm.idCliente){
					cliente.setUsuario(usuario);
					PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
					
					RawMessage rawMessageLogin = new RawMessage();
			    	rawMessageLogin.type = "enemigoConsultaResponse";
			    	rawMessageLogin.message = new EnviarEnemigosResponseMessage(new Gson().toJson(Servidor.enemigos));
					
					salida.println(new Gson().toJson(rawMessageLogin));
					salida.flush();
				}
		}
		
	}

}
