package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.DAO.PersonajeDAO;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.CrearPersonajeNuevoMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeNuevoConectadoMessage;
import prograavanzada2016.anotherworld.mensajes.response.PersonajeConsultaResponseMessage;
import prograavanzada2016.anotherworld.modelos.PersonajeModel;
import prograavanzada2016.anotherworld.servidor.ClienteServicio;
import prograavanzada2016.anotherworld.servidor.Servidor;

public class CrearPersonajeNuevoService implements ServicioServer{

	@Override
	public void ejecutar(MessageBase message) throws Exception {

		PersonajeDAO personajeDAO = new PersonajeDAO(null, null);
		CrearPersonajeNuevoMessage cpnm = (CrearPersonajeNuevoMessage)message; 
		PersonajeModel pm = new Gson().fromJson(cpnm.Payload, PersonajeModel.class);
		
		if(personajeDAO.insertar(pm)){
			for(ClienteServicio cliente : Servidor.clientesSala1){
				//hay un personaje, le avisamos a su dueño y a todos los demas
					if(cliente.getId() == cpnm.idCliente){
						System.out.println("soy el que envio la peticion");
						PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
						
						RawMessage rawMessageLogin = new RawMessage();
				    	rawMessageLogin.type = "crearPersonajeResponse";
				    	rawMessageLogin.message = new PersonajeConsultaResponseMessage(new Gson().toJson(pm));
						
						salida.println(new Gson().toJson(rawMessageLogin));
						salida.flush();
					}else{
						/*System.out.println("soy los demas");
						PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
						
						RawMessage rawMessageLogin = new RawMessage();
				    	rawMessageLogin.type = "personajeNuevoConectado";
				    	rawMessageLogin.message = new PersonajeNuevoConectadoMessage(new Gson().toJson(usuario));
						
						salida.println(new Gson().toJson(rawMessageLogin));
						salida.flush();*/
					}
			}			
		}else{
			//error de creacion de personaje
		}
	
		
	}

}
