package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.MoverMessage;
import prograavanzada2016.anotherworld.mensajes.response.LoginMessageResponse;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.servidor.ClienteServicio;
import prograavanzada2016.anotherworld.servidor.Servidor;

public class MoverService implements ServicioServer{

	@Override
	public void ejecutar(MessageBase message) throws Exception {
		MoverMessage mm = (MoverMessage) message;
		Usuario usuario = new Gson().fromJson(mm.Payload, Usuario.class);
		for(ClienteServicio cliente : Servidor.clientesSala1){
				if(cliente.getId() != mm.idCliente && !cliente.getSocket().isClosed()){
					PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
					
					RawMessage rawMessageLogin = new RawMessage();
			    	rawMessageLogin.type = "moverPersonajeResponse";
			    	rawMessageLogin.message = new LoginMessageResponse(new Gson().toJson(usuario));
					
					salida.println(new Gson().toJson(rawMessageLogin));
					salida.flush();
				}
		}
	}

}
