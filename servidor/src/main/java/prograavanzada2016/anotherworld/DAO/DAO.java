package prograavanzada2016.anotherworld.DAO;

import java.util.List;

import prograavanzada2016.anotherworld.entities.Personaje;

public abstract class DAO<T>{
	public abstract void insertar(T obj) throws DAOException;;
    public abstract void borrar(T obj)throws DAOException;
    public abstract void modificar(T obj) throws  DAOException;
    public abstract long buscar(T obj) throws DAOException;
    public abstract List<T> listarTodos() throws DAOException;
	public void insertar(Personaje personaje, int usuarioID) throws DAOException {
		// TODO Auto-generated method stub
		
	}
}
