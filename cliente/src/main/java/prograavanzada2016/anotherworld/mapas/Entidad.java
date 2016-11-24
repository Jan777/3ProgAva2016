package prograavanzada2016.anotherworld.mapas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.google.gson.Gson;

import prograavanzada2016.anotherworld.modelos.PersonajeModel;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.interfaces.VentanaCombatePvE;
import prograavanzada2016.anotherworld.juego.*;
import prograavanzada2016.anotherworld.mensajes.RawMessage;
import prograavanzada2016.anotherworld.mensajes.request.ConsultaColisionMessage;
import prograavanzada2016.anotherworld.mensajes.request.PersonajeConsultaMessage;
import prograavanzada2016.anotherworld.mensajes.response.PersonajeConsultaResponseMessage;
import prograavanzada2016.anotherworld.utilities.*;

public class Entidad {
		
	private Usuario usuario;
	
	Game juego;

	// Tamaño de la entidad
	private int ancho;
	private int alto;
	
	
	//otroPersonaje
	private int xAutomatico;
	private int yAutomatico;
	
	// Posiciones
	private float x;
	private float y;
	private float dx;
	private float dy;
	private float xInicio;
	private float yInicio;
	private float xFinal;
	private float yFinal;
	private int xOffset;
	private int yOffset;
	private int drawX;
	private int drawY;
	private int posMouse[];
	private int[] tile;

	// Calculo de movimiento
	private float difX;
	private float difY;
	private float relacion;

	// Posicion final
	private float auxX;
	private float auxY;

	// Movimiento Actual
	private boolean enMovimiento;
	private boolean horizontal;
	private boolean vertical;
	private boolean diagonalInfIzq;
	private boolean diagonalInfDer;
	private boolean diagonalSupIzq;
	private boolean diagonalSupDer;

	// Animaciones
	private LinkedList<BufferedImage[]> animaciones;
	private final Animacion moverIzq;
	private final Animacion moverArribaIzq;
	private final Animacion moverArriba;
	private final Animacion moverArribaDer;
	private final Animacion moverDer;
	private final Animacion moverAbajoDer;
	private final Animacion moverAbajo;
	private final Animacion moverAbajoIzq;

	private Mundo mundo;
	
	private boolean soyUsuario=false;
	public boolean tengoUnCaminoAutomatico=false;
	private boolean soyInteligenciaArtificial=false;
	public boolean entroEnCombate=false;
	
	public Entidad(Game juego, Mundo mundo, int ancho, int alto, float spawnX, float spawnY, LinkedList<BufferedImage[]> animaciones, int velAnimacion) throws Exception {
		this.juego = juego;
		this.ancho = ancho;
		this.alto = alto;
		this.mundo = mundo;
		xOffset = ancho / 2;
		yOffset = alto / 2;
		x = spawnX;
		y = spawnY;

		this.animaciones = animaciones;
		 
	    moverIzq = new Animacion(velAnimacion, animaciones.get(0));
	    moverArribaIzq = new Animacion(velAnimacion, animaciones.get(1));
	    moverArriba = new Animacion(velAnimacion, animaciones.get(2));
	    moverArribaDer = new Animacion(velAnimacion, animaciones.get(3));
	    moverDer = new Animacion(velAnimacion, animaciones.get(4));
	    moverAbajoDer = new Animacion(velAnimacion, animaciones.get(5));
	    moverAbajo = new Animacion(velAnimacion, animaciones.get(6));
	    moverAbajoIzq = new Animacion(velAnimacion, animaciones.get(7));
	    this.soyUsuario=true;
	}
	
	public Entidad(Game juego, int ancho, int alto, float spawnX, float spawnY, LinkedList<BufferedImage[]> animaciones, int velAnimacion,boolean inteligenciaArtificial) throws Exception {
		this.juego = juego;
		this.ancho = ancho;
		this.alto = alto;
		xOffset = ancho / 2;
		yOffset = alto / 2;
		x = spawnX;
		y = spawnY;

		this.animaciones = animaciones;
		 
	    moverIzq = new Animacion(velAnimacion, animaciones.get(0));
	    moverArribaIzq = new Animacion(velAnimacion, animaciones.get(1));
	    moverArriba = new Animacion(velAnimacion, animaciones.get(2));
	    moverArribaDer = new Animacion(velAnimacion, animaciones.get(3));
	    moverDer = new Animacion(velAnimacion, animaciones.get(4));
	    moverAbajoDer = new Animacion(velAnimacion, animaciones.get(5));
	    moverAbajo = new Animacion(velAnimacion, animaciones.get(6));
	    moverAbajoIzq = new Animacion(velAnimacion, animaciones.get(7));
	    this.tengoUnCaminoAutomatico=true;
	    this.soyInteligenciaArtificial=inteligenciaArtificial;
	}

	public void actualizar() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		moverIzq.actualizar();
		moverArribaIzq.actualizar();
		moverArriba.actualizar();
		moverArribaDer.actualizar();
		moverDer.actualizar();
		moverAbajoDer.actualizar();
		moverAbajo.actualizar();
		moverAbajoIzq.actualizar();
		
		
		if(soyUsuario){
			getEntrada();
		}else{
			getEntradaAutomatica();
		}
		
		mover();
		if(soyUsuario){
			juego.getCamara().Centrar(this);
		}
	}

	

	public void getEntrada() {

		posMouse = juego.getHandlerMouse().getPosMouse();

		if (juego.getHandlerMouse().getNuevoRecorrido()) {
			diagonalInfIzq = false;
			diagonalInfDer = false;
			diagonalSupIzq = false;
			diagonalSupDer = false;
			vertical = false;
			horizontal = false;
			enMovimiento = false;

			xInicio = x;
			yInicio = y;
						
			xFinal = Math.round(posMouse[0] + juego.getCamara().getxOffset() - xOffset);
			yFinal = Math.round(posMouse[1] + juego.getCamara().getyOffset() - yOffset);
			
			//enviamos coordenadas
			this.juego.getClienteJugable().getUsuario().getPersonaje().setMovimientoX((int)x);
			this.juego.getClienteJugable().getUsuario().getPersonaje().setMovimientoY((int)y);
			this.juego.getClienteJugable().getUsuario().getPersonaje().setMovimientoXFinal((int)xFinal);
			this.juego.getClienteJugable().getUsuario().getPersonaje().setMovimientoYFinal((int)yFinal);
			RawMessage rawMessageLogin = new RawMessage();
			rawMessageLogin.type = "moverPersonaje";
			rawMessageLogin.message = new PersonajeConsultaMessage(new Gson().toJson(this.juego.getClienteJugable().getUsuario()));
			this.juego.getClienteJugable().getClienteManager().sendMensaje(new Gson().toJson(rawMessageLogin));
			
			
			
			System.out.println("movimiento mouse posMouse: "+posMouse[0]+" "+posMouse[1]);
			System.out.println("movimiento mouse en: "+xInicio+" "+yInicio+" "+xFinal+" "+yFinal);
			System.out.println("movimiento mouse camara offset en: "+juego.getCamara().getxOffset()+" "+juego.getCamara().getyOffset());
			System.out.println("movimiento mouse offset en: "+xOffset+" "+yOffset);
			difX = Math.abs(xFinal - xInicio);
			difY = Math.abs(yFinal - yInicio);
			relacion = difX / difY;

			if (difX == 0 || difY == 0) {
				relacion = 1;
			}

			if (difX < ancho && yInicio != yFinal) {
				vertical = true;
				horizontal = true;
			}
			if (difY < alto && xInicio != xFinal) {
				horizontal = true;
				vertical = true;
			}

			if (!vertical && !horizontal) {
				if (xFinal > xInicio && yFinal > yInicio) {
					diagonalInfDer = true;
				} else if (xFinal < xInicio && yFinal > yInicio) {
					diagonalInfIzq = true;
				} else if (xFinal > xInicio && yFinal < yInicio) {
					diagonalSupDer = true;
				} else if (xFinal < xInicio && yFinal < yInicio) {
					diagonalSupIzq = true;
				}
			}

			juego.getHandlerMouse().setNuevoRecorrido(false);
			enMovimiento = true;
		}
	}
	
	
	public void getEntradaAutomatica() {

		//posMouse = juego.getHandlerMouse().getPosMouse();
		int posMouse[] = new int[2];
		
		if (!soyInteligenciaArtificial && this.getUsuario().getPersonaje().isNuevoCamino()) {
			this.getUsuario().getPersonaje().setNuevoCamino(false);
			posMouse[0]=this.getUsuario().getPersonaje().getMovimientoX();
			posMouse[1]=this.getUsuario().getPersonaje().getMovimientoY();
			
			int xOffsetAutomatico = this.getUsuario().getPersonaje().getMovimientoOffsetX();
			int yOffsetAutomatico = this.getUsuario().getPersonaje().getMovimientoOffsetY();
			
			diagonalInfIzq = false;
			diagonalInfDer = false;
			diagonalSupIzq = false;
			diagonalSupDer = false;
			vertical = false;
			horizontal = false;
			enMovimiento = false;

			xInicio = x;
			yInicio = y;
			
			
			xFinal = this.getUsuario().getPersonaje().getMovimientoXFinal();
			yFinal = this.getUsuario().getPersonaje().getMovimientoYFinal();
			
			
			System.out.println("movimiento automatico posMouse: "+posMouse[0]+" "+posMouse[1]);
			System.out.println("movimiento automatico en: "+xInicio+" "+yInicio+" "+xFinal+" "+yFinal);
			System.out.println("movimiento automatico offset en: "+xOffsetAutomatico+" "+yOffsetAutomatico);
			System.out.println("movimiento automatico offset en: "+xOffset+" "+yOffset);
			
			
						
			difX = Math.abs(xFinal - xInicio);
			difY = Math.abs(yFinal - yInicio);
			relacion = difX / difY;

			if (difX == 0 || difY == 0) {
				relacion = 1;
			}

			if (difX < ancho && yInicio != yFinal) {
				vertical = true;
				horizontal = true;
			}
			if (difY < alto && xInicio != xFinal) {
				horizontal = true;
				vertical = true;
			}

			if (!vertical && !horizontal) {
				if (xFinal > xInicio && yFinal > yInicio) {
					diagonalInfDer = true;
				} else if (xFinal < xInicio && yFinal > yInicio) {
					diagonalInfIzq = true;
				} else if (xFinal > xInicio && yFinal < yInicio) {
					diagonalSupDer = true;
				} else if (xFinal < xInicio && yFinal < yInicio) {
					diagonalSupIzq = true;
				}
			}

			//juego.getHandlerMouse().setNuevoRecorrido(false);
			enMovimiento = true;
		}else if(soyInteligenciaArtificial){

			
			diagonalInfIzq = false;
			diagonalInfDer = false;
			diagonalSupIzq = false;
			diagonalSupDer = false;
			vertical = false;
			horizontal = false;
			enMovimiento = false;

			xInicio = x;
			yInicio = y;
			//movimiento de la inteligencia
			/*if(x==300 && y==300){
				xFinal = 300;
				yFinal = 400;
			}else if(x==300 && y==400){
				xFinal=400;
				yFinal=400;
			}else if(x==400 && y==400){
				xFinal=300;
				yFinal=400;
			}else if(x==300 && y==400){
				xFinal=300;
				yFinal=300;
			}*/
			
			this.calcularMovimientoDeMaquina(x,y);
			
						
			difX = Math.abs(xFinal - xInicio);
			difY = Math.abs(yFinal - yInicio);
			relacion = difX / difY;

			if (difX == 0 || difY == 0) {
				relacion = 1;
			}

			if (difX < ancho && yInicio != yFinal) {
				vertical = true;
				horizontal = true;
			}
			if (difY < alto && xInicio != xFinal) {
				horizontal = true;
				vertical = true;
			}

			if (!vertical && !horizontal) {
				if (xFinal > xInicio && yFinal > yInicio) {
					diagonalInfDer = true;
				} else if (xFinal < xInicio && yFinal > yInicio) {
					diagonalInfIzq = true;
				} else if (xFinal > xInicio && yFinal < yInicio) {
					diagonalSupDer = true;
				} else if (xFinal < xInicio && yFinal < yInicio) {
					diagonalSupIzq = true;
				}
			}

			//juego.getHandlerMouse().setNuevoRecorrido(false);
			enMovimiento = true;
		
		}
	}
	
	//private void getEntradaAutomaticaEnemigos() {}
	
	public void mover() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		dx = 0;
		dy = 0;
		
		
		
		if (enMovimiento && (x != xFinal || y != yFinal)) {

			Entidad entidad=this.chechColition(x,y);
			if(entidad!=null && !this.entroEnCombate && this.soyUsuario){
				
				PrintWriter salida = new PrintWriter(this.juego.getClienteJugable().getSocket().getOutputStream());
				
				RawMessage rawMessageLogin = new RawMessage();
		    	rawMessageLogin.type = "consultaColision";
		    	entidad.getUsuario().setClienteId((int) this.getUsuario().getId());
		    	rawMessageLogin.message = new ConsultaColisionMessage(new Gson().toJson(entidad.getUsuario()));
				
				salida.println(new Gson().toJson(rawMessageLogin));
				salida.flush();
				
				this.entroEnCombate=true;
				VentanaCombatePvE ventana = new VentanaCombatePvE(this,entidad);
				ventana.setVisible(true);
				entidad.entroEnCombate=true;
			}
			
			if (vertical) {
				if (yFinal > y) {
					dy++;
				} else {
					dy--;
				}
			}

			if (horizontal) {
				if (xFinal > x) {
					dx++;
				} else {
					dx--;
				}
			}

			if (diagonalInfDer) {
				dx += relacion;
				dy++;
			} else if (diagonalInfIzq) {
				dx -= relacion;
				dy++;
			} else if (diagonalSupDer) {
				dx += relacion;
				dy--;
			} else if (diagonalSupIzq) {
				dx -= relacion;
				dy--;
			}
			
			auxX += dx;
			auxY += dy;
			
			if(horizontal && dx > x || vertical && dy < y || diagonalInfDer || diagonalInfIzq) {
				auxY += 15;
			}
			
			tile = Mundo.mouseATile(auxX, auxY);
			
			
			
			if (mundo.getTile((int) tile[0], (int) tile[1]).esSolido() || this.entroEnCombate) {
				xFinal = x;
				yFinal = y;
				auxX = x;
				auxY= y;
			} else {
				x += dx;
				y += dy;
				auxX = (int) Math.round(x);
				auxY = (int) Math.round(y);
			}

			if (horizontal || vertical) {
				if (auxX == xFinal) {
					horizontal = false;
				}

				if (auxY == yFinal) {
					vertical = false;
				}
			}
	
			if (auxX == xFinal && auxY == yFinal) {
				diagonalInfIzq = false;
				diagonalInfDer = false;
				diagonalSupIzq = false;
				diagonalSupDer = false;
				enMovimiento = false;
			}
		}
	}

	public void graficar(Graphics g) {
		
		drawX = (int) (x - juego.getCamara().getxOffset());
		drawY = (int) (y - juego.getCamara().getyOffset());
		if(soyInteligenciaArtificial && !entroEnCombate){
			g.drawImage(getFrameAnimacionActual(), drawX, drawY, ancho, alto, null);
			g.drawString("Minotauro Furioso - 5", drawX + 10, drawY - 36);
		}else if(!entroEnCombate){
			g.drawImage(getFrameAnimacionActual(), drawX, drawY, ancho, alto, null);
		}
		if(!soyUsuario && !soyInteligenciaArtificial && !entroEnCombate){
			g.setColor(Color.WHITE);
			g.drawString("Salud: "+ juego.getUser().getPersonaje().getSalud(), drawX +10 , drawY - 24);
			g.drawString(this.getUsuario().getPersonaje().getNombre() + " - "+ this.getUsuario().getPersonaje().getNivel(), drawX + 10, drawY - 36); //aca obtener el nombre del pj
		}
	}

	private BufferedImage getFrameAnimacionActual() {
		if (horizontal && x > xFinal) {
			return moverIzq.getFrameActual();
		} else if (horizontal && x < xFinal) {
			return moverDer.getFrameActual();
		} else if (vertical && y > yFinal) {
			return moverArriba.getFrameActual();
		} else if (vertical && y < yFinal) {
			return moverAbajo.getFrameActual();
		} else if (diagonalInfIzq) {
			return moverAbajoIzq.getFrameActual();
		} else if (diagonalInfDer) {
			return moverAbajoDer.getFrameActual();
		} else if (diagonalSupIzq) {
			return moverArribaIzq.getFrameActual();
		} else if (diagonalSupDer) {
			return moverArribaDer.getFrameActual();
		} else if (soyUsuario && juego.getUser().getPersonaje().getRazaId() == 2){
			return Recursos.humano.get(6)[0];
		}else if(soyUsuario){
			return Recursos.elfo.get(6)[0];
		}else if(soyInteligenciaArtificial){
			return Recursos.minotauro.get(6)[0];
		}else if(!soyUsuario && this.getUsuario().getPersonaje().getRazaId()==2){
			return Recursos.humano.get(6)[0];
		}else if(!soyUsuario && this.getUsuario().getPersonaje().getRazaId()==1){
			return Recursos.elfo.get(6)[0];
		}
		return null;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	public int getxOffset() {
		return xOffset;
	}
	
	public int getYOffset() {
		return yOffset;
	}

	public int getxAutomatico() {
		return xAutomatico;
	}

	public void setxAutomatico(int xAutomatico) {
		this.xAutomatico = xAutomatico;
	}

	public int getyAutomatico() {
		return yAutomatico;
	}

	public void setyAutomatico(int yAutomatico) {
		this.yAutomatico = yAutomatico;
	}

	public Mundo getMundo() {
		return mundo;
	}

	public void setMundo(Mundo mundo) {
		this.mundo = mundo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
	public Entidad chechColition(float xActual,float yActual){
		if(!this.entroEnCombate){
			int tileColision[] = Mundo.mouseATile(xActual, yActual);
			
			for(Entidad ent : this.juego.getEstadoJuego().getEnemigos()){
				int tileColisionOtro[] = Mundo.mouseATile(ent.getX(), ent.getY());
				if(!soyInteligenciaArtificial && !ent.entroEnCombate){
					if(tileColision[0]==tileColisionOtro[0] || tileColision[0]==tileColisionOtro[0]+1 || tileColision[0]==tileColisionOtro[0]-1){
						if(tileColision[1]==tileColisionOtro[1] || tileColision[1]==tileColisionOtro[1]+1 || tileColision[1]==tileColisionOtro[1]-1){
							return ent;
						}
					}
				}
			}
		}
		return null;
	}
	
	public void calcularMovimientoDeMaquina(float x, float y){
		if(this.getUsuario().getId()==1){
			if(x==300 && y==300){
				xFinal = 300;
				yFinal = 400;
			}else if(x==300 && y==400){
				xFinal=400;
				yFinal=400;
			}else if(x==400 && y==400){
				xFinal=300;
				yFinal=400;
			}else if(x==300 && y==400){
				xFinal=300;
				yFinal=300;
			}
		}else if(this.getUsuario().getId()==2){
			if(x==300 && y==300){
				xFinal = 300;
				yFinal = 1000;
			}else if(x==300 && y==1000){
				xFinal=300;
				yFinal=1100;
			}else if(x==300 && y==1100){
				xFinal=400;
				yFinal=1100;
			}else if(x==400 && y==1100){
				xFinal=400;
				yFinal=1000;
			}else if(x==400 && y==1000){
				xFinal=300;
				yFinal=1000;
			}
		}else if(this.getUsuario().getId()==3){
			System.out.println(x+"-"+y);
			if(x==300 && y==300){
				System.out.println("1");
				xFinal = -500;
				yFinal = 1000;
			}else if(x==-500 && y==1000){
				System.out.println("2");
				xFinal=-500;
				yFinal=900;
			}else if(x==-500 && y==900){
				System.out.println("3");
				xFinal=-400;
				yFinal=900;
			}else if(x==-400 && y==900){
				System.out.println("4");
				xFinal=-400;
				yFinal=1000;
			}else if(x==-400 && y==1000){
				System.out.println("5");
				xFinal=-500;
				yFinal=1000;
			}
		}else if(this.getUsuario().getId()==4){
			if(x==300 && y==300){
				xFinal = 300;
				yFinal = 400;
			}else if(x==300 && y==400){
				xFinal=400;
				yFinal=400;
			}else if(x==400 && y==400){
				xFinal=300;
				yFinal=400;
			}else if(x==300 && y==400){
				xFinal=300;
				yFinal=300;
			}
		}else if(this.getUsuario().getId()==5){
			if(x==300 && y==300){
				xFinal = 300;
				yFinal = 400;
			}else if(x==300 && y==400){
				xFinal=400;
				yFinal=400;
			}else if(x==400 && y==400){
				xFinal=300;
				yFinal=400;
			}else if(x==300 && y==400){
				xFinal=300;
				yFinal=300;
			}
		}
	}
}
