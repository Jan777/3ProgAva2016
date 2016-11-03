package shadegraphics.mapas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import shadegraphics.utilities.BufferedImageLoader;
import shadegraphics.utilities.SpriteSheet;

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

		for(int x=0;x<anchoMapa;x++){
			oldX=(-tileW/2)*x;
			oldY=(+tileH/2)*x;
			for(int y=0;y<largoMapa;y++){
				if(map[x][y]==0){
					g.drawImage(suelo,oldX+offsetTileW,oldY+offsetTileH,null);
				}else{
					g.drawImage(pasto,oldX+offsetTileW,oldY+offsetTileH,null);
				}
				
				oldX+=tileW/2;
				oldY+=tileH/2;
			}
		}
		
	}
}
