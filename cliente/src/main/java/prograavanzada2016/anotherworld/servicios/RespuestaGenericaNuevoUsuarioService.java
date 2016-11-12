package prograavanzada2016.anotherworld.servicios;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.interfaces.VentanaPrincipal;
import prograavanzada2016.anotherworld.mensajes.MessageBase;
import prograavanzada2016.anotherworld.mensajes.RespuestaGenericaMessage;
import prograavanzada2016.anotherworld.modelos.RespuestaGenerica;

public class RespuestaGenericaNuevoUsuarioService implements ServicioServer{
	private VentanaPrincipal ventanaPrincipal;
	private ClienteJugable clienteJugable;
	public RespuestaGenericaNuevoUsuarioService(ClienteJugable clienteJugable){
		this.clienteJugable = clienteJugable;
	}

	@Override
	public void ejecutar(MessageBase message) throws Exception {
		RespuestaGenericaMessage rgm = (RespuestaGenericaMessage) message;
		
		RespuestaGenerica rg = new Gson().fromJson(rgm.Payload, RespuestaGenerica.class);
		
		if(rg.isEstado()){
			ventanaPrincipal = new VentanaPrincipal(clienteJugable);
			JOptionPane.showMessageDialog(ventanaPrincipal, "Usuario registrado con exito");
		}else{
			ventanaPrincipal = new VentanaPrincipal(clienteJugable);
			JOptionPane.showMessageDialog(ventanaPrincipal, "Problemas para registrar usuario por favor intente nuevamente.");
		}
	}

}
