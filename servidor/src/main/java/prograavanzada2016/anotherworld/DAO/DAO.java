package prograavanzada2016.anotherworld.DAO;

import java.util.List;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.modelos.PersonajeModel;

public abstract class DAO<T>{
	public abstract boolean insertar(T obj) throws DAOException;
    public abstract void borrar(T obj)throws DAOException;
    public abstract void modificar(T obj) throws  DAOException;
    public abstract long buscar(T obj) throws DAOException;
    public abstract List<T> listarTodos() throws DAOException;
}
