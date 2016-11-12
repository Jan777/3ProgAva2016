package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.DAO.PersonajeDAO;
import prograavanzada2016.anotherworld.mensajes.LoginMessage;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.PersonajeConsultaResponseMessage;
import prograavanzada2016.anotherworld.mensajes.PersonajeNuevoConectadoMessage;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.servidor.ClienteServicio;
import prograavanzada2016.anotherworld.servidor.Servidor;

public class PersonajeConsultaService implements ServicioServer{

	@Override
	public void ejecutar(MessageBase message) throws Exception {
		PersonajeDAO personajeDAO = new PersonajeDAO(null, null);
		PersonajeConsultaMessage pcm = (PersonajeConsultaMessage)message; 
		Usuario usuario = new Gson().fromJson(pcm.Payload, Usuario.class);
		//el 1==1 lo hacemos para que siempre vaya ahi aunque no lo encuentre
		//la logica de saber si llego o no esta en el cliente
		//deberiamos modificar esto pero no tenemos tiempo
		if(personajeDAO.buscar(usuario)==1){
			//si lo encuentra tenemos que avisarle a todos
			System.out.println("enrttamos");
			for(ClienteServicio cliente : Servidor.clientesSala1){
					if(cliente.getId() == pcm.idCliente){
						System.out.println("encontrado");
						PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
						
						RawMessage rawMessageLogin = new RawMessage();
				    	rawMessageLogin.type = "personajeConsultaResponse";
				    	rawMessageLogin.message = new PersonajeConsultaResponseMessage(new Gson().toJson(usuario));
						
						salida.println(new Gson().toJson(rawMessageLogin));
						salida.flush();
					}else{
						System.out.println("encontrado");
						PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
						
						RawMessage rawMessageLogin = new RawMessage();
				    	rawMessageLogin.type = "personajeNuevoConectado";
				    	rawMessageLogin.message = new PersonajeNuevoConectadoMessage(new Gson().toJson(usuario));
						
						salida.println(new Gson().toJson(rawMessageLogin));
						salida.flush();
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
