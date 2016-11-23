package prograavanzada2016.anotherworld.DAO;

import java.util.List;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.modelos.PersonajeModel;

public abstract class DAO<T>{
	public abstract boolean insertar(T obj) throws Exception;
    public abstract void borrar(T obj)throws Exception;
    public abstract void modificar(T obj) throws  Exception;
    public abstract long buscar(T obj) throws Exception;
    public abstract List<T> listarTodos() throws Exception;
}
