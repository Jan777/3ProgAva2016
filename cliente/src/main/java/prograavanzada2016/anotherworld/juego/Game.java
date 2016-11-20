package prograavanzada2016.anotherworld.juego;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.FileNotFoundException;
import java.io.IOException;

import prograavanzada2016.anotherworld.cliente.ClienteJugable;
import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.interfaces.*;
import prograavanzada2016.anotherworld.utilities.*;
import prograavanzada2016.anotherworld.mapas.*;
import prograavanzada2016.anotherworld.modelos.Usuario;


public class Game implements Runnable{
	
	private GameScreen screen;
	private final String nombre;
	private final int width;
	private final int height;
	private Usuario user;

	private Thread hilo;
	private boolean corriendo;

	private BufferStrategy bs; // Estrategia para graficar mediante buffers (Primero se "grafica" en el/los buffer/s y finalmente en el canvas)
	private Graphics g;

	// Estados
	private Estado estadoJuego;
	
	// Controlador del point and click
	private MouseController mouseController;
	
	// Controlador de Camara
	private Camera camara;
	
	private ClienteJugable clienteJugable;

	public Game(final String nombre, final int width, final int height, ClienteJugable clienteJugable) {
		this.clienteJugable=clienteJugable;
		this.nombre = nombre;
		this.width = width;
		this.height = height;
		this.user = clienteJugable.getUsuario();
		mouseController = new MouseController();
		mouseController.setClienteJugable(clienteJugable);
	}

	public void initGame() throws FileNotFoundException, IOException { // Carga lo necesario para iniciar el juego
		screen = new GameScreen(nombre, width, height);

		screen.getCanvas().addMouseListener(mouseController);

		Recursos.cargar();

		estadoJuego = new EstadoJuego(this);
		Estado.setEstado(estadoJuego);
		
		camara = new Camera(this, 0, 0);
	}

	private void actualizar() { // Actualiza los objetos y sus posiciones
		mouseController.actualizar();

		if (Estado.getEstado() != null) {
			Estado.getEstado().actualizar();
		}
	}

	private void graficar() { // Grafica los objetos y sus posiciones
		bs = screen.getCanvas().getBufferStrategy();
		if (bs == null) { // Seteo una estrategia para el canvas en caso de que no tenga una
			screen.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics(); // Permite graficar el buffer mediante g

		g.clearRect(0, 0, width, height); // Limpiamos la pantalla

		// Graficado de imagenes
		
		if (Estado.getEstado() != null) {
			estadoJuego.graficar(g);
		}

		// Fin de graficado de imagenes

		bs.show(); // Hace visible el próximo buffer disponible
		g.dispose();
	}

	@Override
	public void run() { // Hilo principal del juego
		try {
			initGame();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int fps = 60; // Cantidad de actualizaciones por segundo que se desean
		double tiempoPorActualizacion = 1000000000 / fps; // Cantidad de nanosegundos en FPS deseados
		double delta = 0;
		long ahora;
		long ultimoTiempo = System.nanoTime();
		long timer = 0; // Timer para mostrar fps cada un segundo
		int actualizaciones = 0; // Cantidad de actualizaciones que se realizan realmente

		while (corriendo) {
			ahora = System.nanoTime();
			delta += (ahora - ultimoTiempo) / tiempoPorActualizacion; // Calculo  para determinar cuando realizar la actualizacion y el graficado
			timer += ahora - ultimoTiempo; // Sumo el tiempo transcurrido hasta que se acumule 1 segundo y mostrar los FPS
			ultimoTiempo = ahora; // Para las proximas corridas del bucle

			if (delta >= 1) {
				actualizar();
				graficar();
				actualizaciones++;
				delta--;
			}

			if (timer >= 1000000000) { // Si paso 1 segundo muestro los FPS
				screen.getFrame().setTitle(nombre + " | " + "FPS: " + fps);
				actualizaciones = 0;
				timer = 0;
			}
		}

		stop();
	}

	public synchronized void start() { // Inicia el juego
		if (corriendo)
			return;
		corriendo = true;
		hilo = new Thread(this);
		hilo.start();
	}

	public synchronized void stop() { // Detiene el juego
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
		return width;
	}

	public int getAlto() {
		return height;
	}

	public MouseController getHandlerMouse() {
		return mouseController;
	}
	
	public Camera getCamara() {
		return camara;
	}
	
	public EstadoJuego getEstadoJuego() {
		return (EstadoJuego) estadoJuego;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public void agregarNuevoPersonaje(Usuario otroUsuario){
		Entidad personaje=null;
		if(otroUsuario.getPersonaje().getRazaId() == 1){ //Aca construimos nuestro personaje segun el personaje del jugador
			personaje = new Entidad(this, 64, 64, 0, 0, Recursos.elfo, 150);
		} else if (otroUsuario.getPersonaje().getRazaId() == 2){
			personaje = new Entidad(this, 64, 64, 0, 0, Recursos.humano, 150);
		}
		this.estadoJuego.addOtroPersonaje(personaje,otroUsuario);
	}

	public GameScreen getScreen() {
		return screen;
	}

	public void setScreen(GameScreen screen) {
		this.screen = screen;
	}

	public ClienteJugable getClienteJugable() {
		return clienteJugable;
	}

	public void setClienteJugable(ClienteJugable clienteJugable) {
		this.clienteJugable = clienteJugable;
	}
	
	
}
