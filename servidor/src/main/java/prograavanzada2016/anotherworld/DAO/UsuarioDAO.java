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
	
	private Statement statement;
    private static final int NO_ENCONTRADO = -1;
    private static final int ENCONTRADO = 1;
     
    public UsuarioDAO(Connection conn, Statement stat) throws SQLException{
    	try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\GitAvanzada\\PrograAvanzada\\jrpg\\servidor\\src\\main\\java\\prograavanzada2016\\anotherworld\\DAO\\jrpg.sqlite");
			conn.setAutoCommit(false);
			statement = conn.createStatement();
			stat = statement;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

	@Override
	public void insertar(Usuario usuario) throws DAOException {
		try {
	       /* if(buscar(usuario)==ENCONTRADO){
	            throw new DAOException("Alumno existente");
	        }*/
	         String insert = "INSERT INT usuario (idUsuario, nombre, apellido, usuario, pass) values('"+usuario.getId()+"','"+usuario.getNombre()+"','"+usuario.getApellido()+"', '"+usuario.getNombreUsuario()+"', '"+usuario.getPassword()+"');";
	         statement.execute(insert);
	        
	       }
	        catch (SQLException ex) {
	            System.out.println(ex);
	        }		
	}
	
	public long existeUsuario(String usuario) throws DAOException {
		try {
			String buscar = "SELECT * FROM usuario where usuario like '"+usuario+"';";
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
            String buscar = "SELECT * FROM usuario where usuario = '"+usuario.getNombreUsuario()+"' and pass = '"+usuario.getPassword()+"';";
            statement.execute(buscar);
            rs = statement.executeQuery(buscar);
            if(rs.next()){
            	usuario.setId(rs.getInt("idUsuario"));
            	usuario.setNombre(rs.getString("nombre"));
            	usuario.setApellido(rs.getString("apellido"));
            	
            	System.out.println("los datos son:"+usuario.getNombre());
            	return ENCONTRADO;
            }else{
                return NO_ENCONTRADO;
            }
            
          /*  String buscarPersonaje = "SELECT * FROM jrpg.personaje where usuario_id = '"+usuario.getId()+"';";
            statement.execute(buscarPersonaje);
            rs = statement.executeQuery(buscar);
            if(rs.next()){
            	personaje = new Personaje(rs.getLong("id"),rs.getString("nombre"),rs.getInt("fuerza"),rs.getInt("salud"),rs.getInt("destreza"),
            			rs.getInt("magia"),rs.getInt("mana"),rs.getInt("energia"),rs.getInt("nivel"),rs.getInt("experiencia"),rs.getLong("casta_id"),
            			rs.getLong("raza_id"),rs.getLong("usuario_id"));
            	
            }*/
            
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
