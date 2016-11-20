package prograavanzada2016.anotherworld.juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.modelos.Usuario;

public class MouseController implements MouseListener {
	private int x;
	private int y;
	private int posMouse[];
	private boolean nuevoRecorrido;
	private Usuario usuario;
	
	public MouseController() {
		posMouse = new int[2];
	}
	
	public void actualizar() {
		posMouse[0] = x;
		posMouse[1] = y;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		nuevoRecorrido = true;
		
		this.usuario.getPersonaje().setMovimientoX(x);
		this.usuario.getPersonaje().setMovimientoY(y);
		RawMessage rawMessageLogin = new RawMessage();
		rawMessageLogin.type = "moverPersonaje";
		rawMessageLogin.message = new PersonajeConsultaMessage(new Gson().toJson(this.usuario));
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	public int[] getPosMouse() {
		return posMouse;
	}

	public boolean getNuevoRecorrido() {
		return nuevoRecorrido;
	}
	
	public void setNuevoRecorrido(boolean b) {
		nuevoRecorrido = b;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
