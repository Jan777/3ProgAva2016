package prograavanzada2016.anotherworld.utilities;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Recursos {

	private static int ANCHO; // Ancho del frame a obtener
	private static int ALTO; // Alto del frame a obtener
	
	// Inicio Personaje	
	public static LinkedList<BufferedImage[]> elfo = new LinkedList<>();
	private static BufferedImage[] elfoIzq;
	private static BufferedImage[] elfoArribaIzq;
	private static BufferedImage[] elfoArriba;
	private static BufferedImage[] elfoArribaDer;
	private static BufferedImage[] elfoDer;
	private static BufferedImage[] elfoAbajoDer;
	private static BufferedImage[] elfoAbajo;
	private static BufferedImage[] elfoAbajoIzq; 
	// Fin Personajes
	
	
	// Inicio Personaje	
		public static LinkedList<BufferedImage[]> humano = new LinkedList<>();
		private static BufferedImage[] humanoIzq;
		private static BufferedImage[] humanoArribaIzq;
		private static BufferedImage[] humanoArriba;
		private static BufferedImage[] humanoArribaDer;
		private static BufferedImage[] humanoDer;
		private static BufferedImage[] humanoAbajoDer;
		private static BufferedImage[] humanoAbajo;
		private static BufferedImage[] humanoAbajoIzq; 
		// Fin Personajes
	
	// Entorno
	public static BufferedImage piso;
	public static BufferedImage pasto;
	public static BufferedImage asfalto;
	public static BufferedImage tierra;
	public static BufferedImage background;
	// Fin Entorno
	
	// Cargo todos los recursos una sola vez para no tener que hacerlo en cada actualizacion
	
	public static void cargar() {
		
		ANCHO = 256;
		ALTO = 256;
		
		// Inicio elfo
		SpriteSheet spriteelfo = new SpriteSheet(CargadorImagen.cargarImagen("/elfo.png"));
		
		elfoIzq = new BufferedImage[4];
		elfoArribaIzq = new BufferedImage[4];
		elfoArriba = new BufferedImage[4];
		elfoArribaDer = new BufferedImage[4];
		elfoDer = new BufferedImage[4];
		elfoAbajoDer = new BufferedImage[4];
		elfoAbajo = new BufferedImage[4];
		elfoAbajoIzq = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			elfoIzq[i] = spriteelfo.getTile(ANCHO*i, 0, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoArribaIzq[i] = spriteelfo.getTile(ANCHO*i, ALTO, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoArriba[i] = spriteelfo.getTile(ANCHO*i, ALTO*2, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoArribaDer[i] = spriteelfo.getTile(ANCHO*i, ALTO*3, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoDer[i] = spriteelfo.getTile(ANCHO*i, ALTO*4, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoAbajoDer[i] = spriteelfo.getTile(ANCHO*i, ALTO*5, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoAbajo[i] = spriteelfo.getTile(ANCHO*i, ALTO*6, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 4; i++) {
			elfoAbajoIzq[i] = spriteelfo.getTile(ANCHO*i, ALTO*7, ANCHO, ALTO);
		}
		
		elfo.add(elfoIzq);
		elfo.add(elfoArribaIzq);
		elfo.add(elfoArriba);
		elfo.add(elfoArribaDer);
		elfo.add(elfoDer);
		elfo.add(elfoAbajoDer);
		elfo.add(elfoAbajo);
		elfo.add(elfoAbajoIzq);
		
		// Fin elfo
		
		
		// Inicio humano
		ANCHO=64;
		ALTO=96;
				SpriteSheet spriteHumano = new SpriteSheet(CargadorImagen.cargarImagen("/human.gif"));
				
				humanoIzq = new BufferedImage[2];
				humanoArribaIzq = new BufferedImage[2];
				humanoArriba = new BufferedImage[2];
				humanoArribaDer = new BufferedImage[2];
				humanoDer = new BufferedImage[2];
				humanoAbajoDer = new BufferedImage[2];
				humanoAbajo = new BufferedImage[2];
				humanoAbajoIzq = new BufferedImage[2];
				
				for(int i = 0; i < 2; i++) {
					humanoIzq[i] = spriteHumano.getTile(ANCHO*5, ALTO*(2+i), ANCHO, ALTO);
				}
				
				for(int i = 0; i < 2; i++) {
					humanoArribaIzq[i] = spriteHumano.getTile(ANCHO*4, ALTO*(2+i), ANCHO, ALTO);
				}
				
				for(int i = 0; i < 2; i++) {
					humanoArriba[i] = spriteHumano.getTile(ANCHO*3, ALTO*(2+i), ANCHO, ALTO);
				}
				
				for(int i = 0; i < 2; i++) {
					humanoArribaDer[i] = spriteHumano.getTile(ANCHO*2, ALTO*(2+i), ANCHO, ALTO);
				}
				
				for(int i = 0; i < 2; i++) {
					humanoDer[i] = spriteHumano.getTile(ANCHO*1, ALTO*(2+i), ANCHO, ALTO);
				}
				
				for(int i = 0; i < 2; i++) {
					humanoAbajoDer[i] = spriteHumano.getTile(ANCHO*0, ALTO*(2+i), ANCHO, ALTO);
				}
				
				for(int i = 0; i < 2; i++) {
					humanoAbajo[i] = spriteHumano.getTile(ANCHO*7, ALTO*(2+i), ANCHO, ALTO);
				}
				
				for(int i = 0; i < 2; i++) {
					humanoAbajoIzq[i] = spriteHumano.getTile(ANCHO*6, ALTO*(2+i), ANCHO, ALTO);
				}
				
				humano.add(humanoIzq);
				humano.add(humanoArribaIzq);
				humano.add(humanoArriba);
				humano.add(humanoArribaDer);
				humano.add(humanoDer);
				humano.add(humanoAbajoDer);
				humano.add(humanoAbajo);
				humano.add(humanoAbajoIzq);
				
				// Fin humano
		
		// Inicio Entorno
		piso =CargadorImagen.cargarImagen("/pisoPosta.png");
		pasto = CargadorImagen.cargarImagen("/pasto.png");
		asfalto = CargadorImagen.cargarImagen("/asfalto.png");
		tierra = CargadorImagen.cargarImagen("/tierra.png");
		
		//background = CargadorImagen.cargarImagen("/background2.jpg");
		// Fin Entorno
	}
}
