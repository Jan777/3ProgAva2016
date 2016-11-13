package prograavanzada2016.anotherworld.juego;

import prograavanzada2016.anotherworld.mapas.Entidad;

public class Camera {
	
	private Game game;
	private float yOffset;
	private float xOffset;

	public Camera(Game game, float xOffset, float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void Centrar(Entidad e) {
		xOffset = e.getX() - game.getAncho() / 2 + e.getAncho() / 2;
		yOffset = e.getY() - game.getAlto() / 2 + e.getAlto() / 2;
	}
	
	public void mover(float dx, float dy) {
		xOffset += dx;
		yOffset += dy;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

}
