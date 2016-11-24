package prograavanzada2016.anotherworld.utilities;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Properties;

import prograavanzada2016.anotherworld.resources.Propiedades;

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
	
	private static BufferedImage[] elfoMuerte;
	private static BufferedImage[] elfoAtaca;
	// Fin Personajes
	
	// Inicio Personaje	
	public static LinkedList<BufferedImage[]> minotauro = new LinkedList<>();
	private static BufferedImage[] minotauroIzq;
	private static BufferedImage[] minotauroArribaIzq;
	private static BufferedImage[] minotauroArriba;
	private static BufferedImage[] minotauroArribaDer;
	private static BufferedImage[] minotauroDer;
	private static BufferedImage[] minotauroAbajoDer;
	private static BufferedImage[] minotauroAbajo;
	private static BufferedImage[] minotauroAbajoIzq; 
	
	private static BufferedImage[] minotauroMuerte; 
	private static BufferedImage[] minotauroAtaca;
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
	
	private static BufferedImage[] humanoMuerte; 
	private static BufferedImage[] humanoAtaca;
	// Fin Personajes
	
	// Entorno
	public static BufferedImage piso;
	public static BufferedImage pasto;
	public static BufferedImage asfalto;
	public static BufferedImage tierra;
	public static BufferedImage background;
	
	public static BufferedImage lago1;
	public static BufferedImage lago2;
	public static BufferedImage lago3;
	public static BufferedImage lago4;
		
	// Fin Entorno
	
	// Cargo todos los recursos una sola vez para no tener que hacerlo en cada actualizacion
	
	public static void cargar() throws Exception {
		
		ANCHO = 256;
		ALTO = 256;
		
		// Inicio elfo
		SpriteSheet spriteelfo = new SpriteSheet(CargadorImagen.cargarImagen(Propiedades.getInstance().getProperty("Elfo")));
		
		elfoIzq = new BufferedImage[4];
		elfoArribaIzq = new BufferedImage[4];
		elfoArriba = new BufferedImage[4];
		elfoArribaDer = new BufferedImage[4];
		elfoDer = new BufferedImage[4];
		elfoAbajoDer = new BufferedImage[4];
		elfoAbajo = new BufferedImage[4];
		elfoAbajoIzq = new BufferedImage[4];
		
		elfoMuerte = new BufferedImage[2];
		elfoAtaca = new BufferedImage[2];
		
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
		
		for(int i = 0; i < 4; i++) {
			elfoAbajoIzq[i] = spriteelfo.getTile(ANCHO*i, ALTO*7, ANCHO, ALTO);
		}
		
		for(int i = 6; i < 7; i++) {
			elfoMuerte[i-6] = spriteelfo.getTile(ANCHO*i, ALTO*4, ANCHO, ALTO);
		}
		
		for(int i = 4; i < 5; i++) {
			elfoAtaca[i-4] = spriteelfo.getTile(ANCHO*i, ALTO*4, ANCHO, ALTO);
		}
		
		elfo.add(elfoIzq);
		elfo.add(elfoArribaIzq);
		elfo.add(elfoArriba);
		elfo.add(elfoArribaDer);
		elfo.add(elfoDer);
		elfo.add(elfoAbajoDer);
		elfo.add(elfoAbajo);
		elfo.add(elfoAbajoIzq);
		
		elfo.add(elfoMuerte);
		elfo.add(elfoAtaca);
		
		// Fin elfo
		
		
		// Inicio humano
		ANCHO=64;
		ALTO=96;
		SpriteSheet spriteHumano = new SpriteSheet(CargadorImagen.cargarImagen(Propiedades.getInstance().getProperty("Humano")));
		
		humanoIzq = new BufferedImage[2];
		humanoArribaIzq = new BufferedImage[2];
		humanoArriba = new BufferedImage[2];
		humanoArribaDer = new BufferedImage[2];
		humanoDer = new BufferedImage[2];
		humanoAbajoDer = new BufferedImage[2];
		humanoAbajo = new BufferedImage[2];
		humanoAbajoIzq = new BufferedImage[2];
		
		humanoMuerte = new BufferedImage[2];
		humanoAtaca = new BufferedImage[2];
		
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
		
		humanoMuerte[0] = spriteHumano.getTile(ANCHO*7, ALTO*5, ANCHO, ALTO);
		
		for(int i = 4; i < 5; i++) {
			humanoAtaca[i-4] = spriteHumano.getTile(ANCHO, ALTO*i, ANCHO, ALTO);
		}
		
		humano.add(humanoIzq);
		humano.add(humanoArribaIzq);
		humano.add(humanoArriba);
		humano.add(humanoArribaDer);
		humano.add(humanoDer);
		humano.add(humanoAbajoDer);
		humano.add(humanoAbajo);
		humano.add(humanoAbajoIzq);
		
		humano.add(humanoMuerte);
		humano.add(humanoAtaca);
		
		// Fin humano
				
		//comienza minotauro
		
		ANCHO = 128;
		ALTO = 128;
		SpriteSheet spriteminotauro = new SpriteSheet(CargadorImagen.cargarImagen(Propiedades.getInstance().getProperty("Minotauro")));

		minotauroIzq = new BufferedImage[7];
		minotauroArribaIzq = new BufferedImage[7];
		minotauroArriba = new BufferedImage[7];
		minotauroArribaDer = new BufferedImage[7];
		minotauroDer = new BufferedImage[7];
		minotauroAbajoDer = new BufferedImage[7];
		minotauroAbajo = new BufferedImage[7];
		minotauroAbajoIzq = new BufferedImage[7];
		
		minotauroMuerte = new BufferedImage[7];
		minotauroAtaca = new BufferedImage[3];
		
		for(int i = 4; i < 11; i++) {
			minotauroIzq[i-4] = spriteminotauro.getTile(ANCHO*i, 0, ANCHO, ALTO);
		}
		
		for(int i = 4; i < 11; i++) {
			minotauroArribaIzq[i-4] = spriteminotauro.getTile(ANCHO*i, ALTO, ANCHO, ALTO);
		}
		
		for(int i = 4; i < 11; i++) {
			minotauroArriba[i-4] = spriteminotauro.getTile(ANCHO*i, ALTO*2, ANCHO, ALTO);
		}
		
		for(int i = 4; i < 11; i++) {
			minotauroArribaDer[i-4] = spriteminotauro.getTile(ANCHO*i, ALTO*3, ANCHO, ALTO);
		}
		
		for(int i = 4; i < 11; i++) {
			minotauroDer[i-4] = spriteminotauro.getTile(ANCHO*i, ALTO*4, ANCHO, ALTO);
		}
		
		for(int i = 4; i < 11; i++) {
			minotauroAbajoDer[i-4] = spriteminotauro.getTile(ANCHO*i, ALTO*5, ANCHO, ALTO);
		}
		
		for(int i = 4; i < 11; i++) {
			minotauroAbajo[i-4] = spriteminotauro.getTile(ANCHO*i, ALTO*6, ANCHO, ALTO);
		}
		
		for(int i = 4; i < 11; i++) {
			minotauroAbajoIzq[i-4] = spriteminotauro.getTile(ANCHO*i, ALTO*7, ANCHO, ALTO);
		}
		
		for(int i = 0; i < 7; i++) {
			minotauroMuerte[i] = spriteminotauro.getTile(ANCHO*i, ALTO, ANCHO, ALTO);
		}
		for(int i = 0; i < 3; i++) {
			minotauroAtaca[i] = spriteminotauro.getTile(ANCHO*i, ALTO, ANCHO, ALTO);
		}
		
		minotauro.add(minotauroIzq);
		minotauro.add(minotauroArribaIzq);
		minotauro.add(minotauroArriba);
		minotauro.add(minotauroArribaDer);
		minotauro.add(minotauroDer);
		minotauro.add(minotauroAbajoDer);
		minotauro.add(minotauroAbajo);
		minotauro.add(minotauroAbajoIzq);
		
		minotauro.add(minotauroMuerte);
		minotauro.add(minotauroAtaca);
		//fin minotauro
		
		// Inicio Entorno
		piso =CargadorImagen.cargarImagen(Propiedades.getInstance().getProperty("Piso"));
		pasto = CargadorImagen.cargarImagen(Propiedades.getInstance().getProperty("Pasto"));
		asfalto = CargadorImagen.cargarImagen(Propiedades.getInstance().getProperty("Asfalto"));
		tierra = CargadorImagen.cargarImagen(Propiedades.getInstance().getProperty("Tierra"));
		
		lago1 = CargadorImagen.cargarImagen(Propiedades.getInstance().getProperty("Lago1"));
		lago2 = CargadorImagen.cargarImagen(Propiedades.getInstance().getProperty("Lago2"));
		lago3 = CargadorImagen.cargarImagen(Propiedades.getInstance().getProperty("Lago3"));
		lago4 = CargadorImagen.cargarImagen(Propiedades.getInstance().getProperty("Lago4"));
		
		//background = CargadorImagen.cargarImagen("/background2.jpg");
		// Fin Entorno
	}
}
