package prograavanzada2016.anotherworld.juego;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import prograavanzada2016.anotherworld.estadoJuego.Estado;
import prograavanzada2016.anotherworld.estadoJuego.EstadoJuego;
import prograavanzada2016.anotherworld.utilities.Recursos;

public class Juego implements Runnable {

	private Pantalla pantalla;
	private final String NOMBRE;
	private final int ANCHO;
	private final int ALTO;
	private Thread hilo;
	private boolean corriendo;
	private BufferStrategy bs; 
	private Graphics g;

	// Estados
	private Estado estadoJuego;

	// HandlerMouse
	private HandlerMouse handlerMouse;
	
	// Camara
	private Camara camara;

	public Juego(final String nombre, final int ancho, final int alto) {
		this.NOMBRE = nombre;
		this.ALTO = alto;
		this.ANCHO = ancho;
		handlerMouse = new HandlerMouse();
	}

	public void iniciar() { 
		pantalla = new Pantalla(NOMBRE, ANCHO, ALTO);
		pantalla.getCanvas().addMouseListener(handlerMouse);
		Recursos.cargar();
		estadoJuego = new EstadoJuego(this);
		Estado.setEstado(estadoJuego);
		camara = new Camara(this, 0, 0);
	}

	private void actualizar() {
		handlerMouse.actualizar();
		if (Estado.getEstado() != null) {
			Estado.getEstado().actualizar();
		}
	}

	private void graficar() { 
		bs = pantalla.getCanvas().getBufferStrategy();
		if (bs == null) { 
			pantalla.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, ANCHO, ALTO); 
		if (Estado.getEstado() != null) {
			estadoJuego.graficar(g);
		}
		bs.show(); 
		g.dispose();
	}

	@Override
	public void run() {
		iniciar();
		int fps = 60;
		double tiempoPorActualizacion = 1000000000 / fps; 
		double delta = 0;
		long ahora;
		long ultimoTiempo = System.nanoTime();
		long timer = 0; 
		int actualizaciones = 0; 

		while (corriendo) {
			ahora = System.nanoTime();
			delta += (ahora - ultimoTiempo) / tiempoPorActualizacion; 
			timer += ahora - ultimoTiempo;
			ultimoTiempo = ahora;

			if (delta >= 1) {
				actualizar();
				graficar();
				actualizaciones++;
				delta--;
			}
			if (timer >= 1000000000) {
				pantalla.getFrame().setTitle(NOMBRE + " | " + "FPS: " + fps);
				actualizaciones = 0;
				timer = 0;
			}
		}
		stop();
	}

	public synchronized void start() { 
		if (corriendo)
			return;
		corriendo = true;
		hilo = new Thread(this);
		hilo.start();
	}
	public synchronized void stop() { 
		if (!corriendo)
			return;
		try {
			corriendo = false;
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getAncho() {
		return ANCHO;
	}
	
	public int getAlto() {
		return ALTO;
	}
	
	public HandlerMouse getHandlerMouse() {
		return handlerMouse;
	}

	public Camara getCamara() {
		return camara;
	}
	
	public EstadoJuego getEstadoJuego() {
		return (EstadoJuego) estadoJuego;
	}
}
