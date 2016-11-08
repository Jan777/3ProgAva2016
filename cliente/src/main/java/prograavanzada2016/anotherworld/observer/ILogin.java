package prograavanzada2016.anotherworld.observer;

public interface ILogin {
	//1-"OK num" num vendria a ser el numero de clienteId devuelto por el servidor
	//2-"FAIL" no se pudo realizar el login
	public void update(String response);
}
