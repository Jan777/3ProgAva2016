package prograavanzada2016.anotherworld.mapas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import prograavanzada2016.anotherworld.utilities.BufferedImageLoader;
import prograavanzada2016.anotherworld.utilities.SpriteSheet;



public class Mapa extends Canvas{
	private static final int tileW = 64;
	private static final int tileH = 32;
	
	private static final int offsetTileW = 320;
	private static final int offsetTileH = 160;
	
	int oldX=0;
	int oldY=0;
	
	boolean flag=true;
	
	private int anchoMapa=4;
	private int largoMapa=4;
	
	private int[][] map =
		{
		    {0,0,0,1},
		    {0,1,0,1},
		    {0,0,0,1},
		    {1,1,0,1}
		 };
	
	private BufferedImage suelo;
	private BufferedImage pasto;
	
	public Mapa(){
		setSize(new Dimension(320, 160));
		this.iniciar();
	}
	
	public int[][] getMap() {
		return map;
	}
	public void setMap(int[][] map) {
		this.map = map;
	}
	
	private void iniciar() {
		BufferedImageLoader bi = new BufferedImageLoader();
		SpriteSheet hoja = new SpriteSheet(bi.loadImage("pisoPosta.png")); 
		this.suelo=hoja.getTile(0, 0, 64, 32);
		
		SpriteSheet hoja2 = new SpriteSheet(bi.loadImage("tilePosta2.png")); 
		this.pasto=hoja2.getTile(0, 0, 64, 32);
	}
	
	@Override
	public void paint(Graphics g){
		//armo el mapa
		//lo pienso como una matriz pero como es isometrico tengo que imaginar
		//los cuadrados con un giro de 45°
		//aca hay dos variables que todavia no tengo medidas que son
		//offsetTileH y offsetTileW estas dos variables me sirven para mover el dibujo y posicionarlo donde yo quiera
		//para que la pantalla no me salga cortada
		for(int x=0;x<anchoMapa;x++){
			//bajo un nivel el dibujo
			//mas info
			//http://www.java-gaming.org/topics/drawing-isometric-tiles-inside-a-screen/24922/msg/212780/view.html
			oldX=(-tileW/2)*x;
			oldY=(+tileH/2)*x;
			for(int y=0;y<largoMapa;y++){
				if(map[x][y]==0){
					//si el contenido del array es un 0 dibujo cierto tile
					g.drawImage(suelo,oldX+offsetTileW,oldY+offsetTileH,null);
				}else if(map[x][y]==1){
					//si el contenido del array es un 1 dibujo cierto tile
					g.drawImage(pasto,oldX+offsetTileW,oldY+offsetTileH,null);
				}else{
					//por default dibujo cierto tile
					g.drawImage(suelo,oldX+offsetTileW,oldY+offsetTileH,null);
				}
				//cuando dibujo un cuadrado el siguiente cuadrado tiene que empezar
				//en la mitad del que dibuje anteriormente por eso me muevo la mitad del ancho y del largo
				//hacia adentro
				//mas info
				//http://www.java-gaming.org/topics/drawing-isometric-tiles-inside-a-screen/24922/msg/212780/view.html
				oldX+=tileW/2;
				oldY+=tileH/2;
			}
		}
		
	}
}
