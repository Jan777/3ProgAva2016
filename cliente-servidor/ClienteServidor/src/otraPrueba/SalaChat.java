package otraPrueba;

import java.util.*;

public class SalaChat
{
	private String nombre;
	private List<Usuario> usuarios;
	
	public SalaChat(String nombre)
	{
		this.nombre = nombre;
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void agregarUsuarioASala(Usuario u)
	{
		this.usuarios.add(u);
	}

}
