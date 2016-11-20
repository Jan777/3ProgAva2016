package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.ConsultarPersonajesConectadosMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.response.PersonajeConsultaResponseMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.servidor.ClienteServicio;
import prograavanzada2016.anotherworld.servidor.Servidor;

public class BuscarPersonajesService implements ServicioServer{

	@Override
	public void ejecutar(MessageBase message) throws Exception {
		ConsultarPersonajesConectadosMessage pcm = (ConsultarPersonajesConectadosMessage)message; 
		
		for(ClienteServicio cliente : Servidor.clientesSala1){
			//hay un personaje, le avisamos a su dueño y a todos los demas
				if(cliente.getId() == pcm.idCliente){
					//logica para obtener los usuarios que ya estan adentro
					ArrayList<Usuario> usuariosAdentro = new ArrayList<>();
					for(ClienteServicio clienteAdentro : Servidor.clientesSala1){
						if(clienteAdentro.getId()!=pcm.idCliente){
							usuariosAdentro.add(clienteAdentro.getUsuario());
						}
					}
					PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
					
					RawMessage rawMessageLogin = new RawMessage();
			    	rawMessageLogin.type = "recibirPersonajes";
			    	rawMessageLogin.message = new PersonajeConsultaResponseMessage(new Gson().toJson(usuariosAdentro));
					
					salida.println(new Gson().toJson(rawMessageLogin));
					salida.flush();
					//fin de logica
				}
		}
		
	}

}
