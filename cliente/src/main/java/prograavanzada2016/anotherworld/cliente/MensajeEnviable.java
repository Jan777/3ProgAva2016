package prograavanzada2016.anotherworld.cliente;

public class MensajeEnviable {
	private int codigo;
	private String mensaje;
	
	public MensajeEnviable(int codigo, String mensaje) throws Exception{
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
