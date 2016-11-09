package prograavanzada2016.anotherworld.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.user.Usuario;

public class UsuarioDAO extends DAO<Usuario>{
	
	private final Statement statement;
    private static final int NO_ENCONTRADO = -1;
    private static final int ENCONTRADO = 1;
     
    public UsuarioDAO(Connection conn, Statement stat) throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/jrpg", "root", "1234");
        statement = conn.createStatement();
        stat = statement;
    }

	@Override
	public void insertar(Usuario usuario) throws DAOException {
		try {
	       /* if(buscar(usuario)==ENCONTRADO){
	            throw new DAOException("Alumno existente");
	        }*/
	         String insert = "insert into jrpg.usuario (nombre, apellido, nombreUsuario, pass) values('"+usuario.getNombre()+"','"+usuario.getApellido()+"','"+usuario.getNombreUsuario()+"', '"+usuario.getPassword()+"');";
	         statement.execute(insert);
	        
	       }
	        catch (SQLException ex) {
	            System.out.println(ex);
	        }		
	}
	
	public long existeUsuario(String usuario) throws DAOException {
		try {
			String buscar = "select * from jrpg.usuario where nombreUsuario like '"+usuario+"';";
			statement.execute(buscar);
			ResultSet rs = statement.executeQuery(buscar);
			if(rs.next())
				return ENCONTRADO;
				else
				return NO_ENCONTRADO;
					
		}catch (SQLException ex) {
	    	ex.printStackTrace();
	        return NO_ENCONTRADO;
	    }
		}

	@Override
	public void borrar(Usuario usuario) throws DAOException {
	}

	@Override
	public void modificar(Usuario usuario) throws DAOException {
	}

	@Override
	public long buscar(Usuario usuario) throws DAOException {
		try {
			ResultSet rs;
			Personaje personaje;
            String buscar = "select * from jrpg.usuario where nombreUsuario like '"+usuario.getNombreUsuario()+"' and pass like '"+usuario.getPassword()+"';";
            statement.execute(buscar);
            rs = statement.executeQuery(buscar);
            if(rs.next()){
            	usuario.setId(rs.getLong("id"));
            	usuario.setNombre(rs.getString("nombre"));
            	usuario.setApellido(rs.getString("apellido"));
            }else{
                return NO_ENCONTRADO;
            }
            
            String buscarPersonaje = "select * from jrpg.personaje where usuario_id = '"+usuario.getId()+"';";
            statement.execute(buscarPersonaje);
            rs = statement.executeQuery(buscar);
            if(rs.next()){
            	personaje = new Personaje(rs.getLong("id"),rs.getString("nombre"),rs.getInt("fuerza"),rs.getInt("salud"),rs.getInt("destreza"),
            			rs.getInt("magia"),rs.getInt("mana"),rs.getInt("energia"),rs.getInt("nivel"),rs.getInt("experiencia"),rs.getLong("casta_id"),
            			rs.getLong("raza_id"),rs.getLong("usuario_id"));
            	
            }
            
        }catch (SQLException ex) {
        	ex.printStackTrace();
            return NO_ENCONTRADO;
        }
	}

	@Override
	public List<Usuario> listarTodos() throws DAOException {
		return null;
	}

}
