package prograavanzada2016.anotherworld.servicios;

import java.io.PrintWriter;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.ConsultaColisionMessage;
import prograavanzada2016.anotherworld.mensajes.response.ConsultaColisionResponseMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.servidor.ClienteServicio;
import prograavanzada2016.anotherworld.servidor.Servidor;

public class ConsultaColisionService implements ServicioServer{
	@Override
	public void ejecutar(MessageBase message) throws Exception {
		ConsultaColisionMessage ccm = (ConsultaColisionMessage)message;
		Usuario enemigo = new Gson().fromJson(ccm.Payload, Usuario.class);
		
		for(ClienteServicio cliente : Servidor.clientesSala1){
			if(ccm.idCliente!=cliente.getId()){
				PrintWriter salida = new PrintWriter(cliente.getSocket().getOutputStream());
				//enemigo.setClienteId(ccm.idCliente);
				RawMessage rawMessageLogin = new RawMessage();
				rawMessageLogin.type = "consultaColisionResponse";
		    	rawMessageLogin.message = new ConsultaColisionResponseMessage(new Gson().toJson(enemigo));
				
				salida.println(new Gson().toJson(rawMessageLogin));
				salida.flush();
			}
		}
	}

}
