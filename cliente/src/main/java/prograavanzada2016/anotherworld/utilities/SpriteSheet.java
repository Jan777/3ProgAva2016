package prograavanzada2016.anotherworld.utilities;

import java.awt.image.BufferedImage;
import java.util.Observable;

public class SpriteSheet extends Observable{

	private BufferedImage sprite;
	
	public SpriteSheet(BufferedImage sprite) throws Exception{
		this.sprite = sprite;
	}
	
	public BufferedImage getTile(int x, int y, int ancho, int alto) throws Exception{
		return sprite.getSubimage(x, y, ancho, alto);
	}
}