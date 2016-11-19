package prograavanzada2016.anotherworld.servicios;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.interfaces.VentanaCrearPersonaje;
import prograavanzada2016.anotherworld.interfaces.VentanaDeBienvenida;
import prograavanzada2016.anotherworld.juego.Game;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeNuevoConectadoMessage;
import prograavanzada2016.anotherworld.mensajes.response.PersonajeConsultaResponseMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;

public class PersonajeNuevoResponseService implements ServicioServer{private ClienteJugable clienteJugable;

public PersonajeNuevoResponseService(ClienteJugable clienteJugable) {
	this.clienteJugable=clienteJugable;
}

@Override
public void ejecutar(MessageBase message) throws Exception {
	PersonajeNuevoConectadoMessage resp = (PersonajeNuevoConectadoMessage) message;
	Usuario usuario = new Gson().fromJson(resp.Payload, Usuario.class);
	clienteJugable.getOtrosClientes().add(usuario);
	System.out.println("se agrego un nuevo personaje");
	new VentanaDeBienvenida(clienteJugable);		
}}
