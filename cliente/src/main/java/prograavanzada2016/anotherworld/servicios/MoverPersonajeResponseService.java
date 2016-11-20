package prograavanzada2016.anotherworld.servicios;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.response.MoverResponseMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;

public class MoverPersonajeResponseService implements ServicioServer{
	private ClienteJugable clienteJugable;
	public MoverPersonajeResponseService(ClienteJugable clienteJugable) {
		this.clienteJugable=clienteJugable;
	}
	
	@Override
	public void ejecutar(MessageBase message) throws Exception {
		MoverResponseMessage resp = (MoverResponseMessage) message;
		Usuario usuarioSeMovio = new Gson().fromJson(resp.Payload, Usuario.class);
		for(Usuario otroUsuario : this.clienteJugable.getOtrosClientes()){
			if(otroUsuario.getId()==usuarioSeMovio.getId()){
				otroUsuario.getPersonaje().setNuevoCamino(true);
				otroUsuario.getPersonaje().setMovimientoX(usuarioSeMovio.getPersonaje().getMovimientoX());
				otroUsuario.getPersonaje().setMovimientoY(usuarioSeMovio.getPersonaje().getMovimientoY());
				otroUsuario.getPersonaje().setMovimientoXFinal(usuarioSeMovio.getPersonaje().getMovimientoXFinal());
				otroUsuario.getPersonaje().setMovimientoYFinal(usuarioSeMovio.getPersonaje().getMovimientoYFinal());
			}
		}		
}
	

}
