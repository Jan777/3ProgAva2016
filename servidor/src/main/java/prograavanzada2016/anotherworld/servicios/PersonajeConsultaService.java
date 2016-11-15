package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.DAO.PersonajeDAO;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeNuevoConectadoMessage;
import prograavanzada2016.anotherworld.mensajes.response.PersonajeConsultaResponseMessage;
import prograavanzada2016.anotherworld.modelos.PersonajeModel;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.servidor.ClienteServicio;
import prograavanzada2016.anotherworld.servidor.Servidor;

public class PersonajeConsultaService implements ServicioServer{

	@Override
	public void ejecutar(MessageBase message) throws Exception {
		PersonajeDAO personajeDAO = new PersonajeDAO(null, null);
		PersonajeConsultaMessage pcm = (PersonajeConsultaMessage)message; 
		Usuario usuario = new Gson().fromJson(pcm.Payload, Usuario.class);
		PersonajeModel pm = new PersonajeModel();
		pm.setUsuarioId(usuario.getId());
		//el 1==1 lo hacemos para que siempre vaya ahi aunque no lo encuentre
		//la logica de saber si llego o no esta en el cliente
		//deberiamos modificar esto pero no tenemos tiempo
		if(personajeDAO.buscar(pm)==1){
			//si lo encuentra tenemos que avisarle a todos
			System.out.println("enrttamos");
			usuario.setPersonaje(pm);
			for(ClienteServicio cliente : Servidor.clientesSala1){
				//hay un personaje, le avisamos a su dueño y a todos los demas
					if(cliente.getId() == pcm.idCliente){
						System.out.println("encontrado");
						PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
						
						RawMessage rawMessageLogin = new RawMessage();
				    	rawMessageLogin.type = "personajeConsultaResponse";
				    	rawMessageLogin.message = new PersonajeConsultaResponseMessage(new Gson().toJson(usuario));
						
						salida.println(new Gson().toJson(rawMessageLogin));
						salida.flush();
					}else{
						if(!cliente.getSocket().isClosed()){
							System.out.println("encontrado");
							PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
							
							RawMessage rawMessageLogin = new RawMessage();
					    	rawMessageLogin.type = "personajeNuevoConectado";
					    	rawMessageLogin.message = new PersonajeNuevoConectadoMessage(new Gson().toJson(usuario));
							
							salida.println(new Gson().toJson(rawMessageLogin));
							salida.flush();
						}
					}
			}			
		}else{
			//si no lo encuentra le avisamos solo a el
			System.out.println("enrttamos2");
			for(ClienteServicio cliente : Servidor.clientesSala1){
					if(cliente.getId() == pcm.idCliente){
						System.out.println("encontrado");
						PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
						
						RawMessage rawMessageLogin = new RawMessage();
				    	rawMessageLogin.type = "personajeConsultaResponse";
				    	rawMessageLogin.message = new PersonajeConsultaResponseMessage(new Gson().toJson(usuario));
						
						salida.println(new Gson().toJson(rawMessageLogin));
						salida.flush();
					}
			}	
		}
	}

}
