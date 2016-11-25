package prograavanzada2016.anotherworld.mapas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile cesped = new TileCesped(0);
	public static Tile fuego = new TileFuego(1);
	public static Tile fuego2 = new TileFuego2(10);
	public static Tile asfalto = new TileAsfalto(2);
	public static Tile tierra = new TileTierra(3);
	public static Tile asfaltoNOpisable = new TileAsfaltoNoPisable(4);
	
	public static Tile lago1 = new TileLago1(5);
	public static Tile lago2 = new TileLago2(6);
	public static Tile lago3 = new TileLago3(7);
	public static Tile lago4 = new TileLago4(8);
	
	public static Tile bush = new TileBush(9);
	
	public static final int ANCHO = 64;
	public static final int ALTO = 32;
	
	protected BufferedImage textura;
	protected final int id;
	
	public Tile(BufferedImage textura, int id) {
		this.textura = textura;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void actualizar() {
		
	}
	
	public void graficar(Graphics g, int x, int y) {
		g.drawImage(textura, x, y, ANCHO, ALTO, null);
	}
	
	public boolean esSolido() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}
