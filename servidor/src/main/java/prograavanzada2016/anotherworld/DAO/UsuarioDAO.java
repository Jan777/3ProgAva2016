package prograavanzada2016.anotherworld.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.modelos.Usuario;
import prograavanzada2016.anotherworld.resources.LogAnother;
import prograavanzada2016.anotherworld.resources.Propiedades;

public class UsuarioDAO extends DAO<Usuario>{
	
	private Statement statement;
	private Connection conn;
    private static final int NO_ENCONTRADO = -1;
    private static final int ENCONTRADO = 1;
     
    public UsuarioDAO(Connection conn, Statement stat) throws Exception{
			Class.forName("org.sqlite.JDBC");
			Propiedades propiedades = Propiedades.getInstance();
			conn = DriverManager.getConnection(propiedades.getProperty("rutaBdd"));
			statement = conn.createStatement();
			stat = statement;
			this.conn=conn;
    }
    

	@Override
	public boolean insertar(Usuario usuario) throws Exception {
		try{	
			int size = 0;
			String count = "select * from usuario";
			ResultSet rs = statement.executeQuery(count);
			//conn.setAutoCommit(false);
			while (rs.next()) {
			    size++;
			}
			size++;
			rs.close();
			
			PreparedStatement statement = conn.prepareStatement(
			        "INSERT INTO 'main'.'usuario' VALUES ("+size+",'"+usuario.getNombre()+"','"+usuario.getApellido()+"','"+usuario.getNombreUsuario()+"','"+usuario.getPassword()+"')");
					statement.executeUpdate();
					//conn.commit();
					conn.close();
			return true;
		}
	        catch (SQLException ex) {
	            LogAnother.getInstance().log(ex);
	        }
		return false;		
	}
	
	public long existeUsuariooo(String usuario) throws DAOException {
//		try {
//			String buscar = "SELECT * FROM usuario where usuario like '"+usuario+"';";
//			//statement.execute(buscar);
//			ResultSet rs = statement.executeQuery(buscar);
//			if(rs.next())
//				return ENCONTRADO;
//				else
//				return NO_ENCONTRADO;
//					
//		}catch (SQLException ex) {
//	    	ex.printStackTrace();
//	        return NO_ENCONTRADO;
//	    }
		return 1;
	}

	@Override
	public void borrar(Usuario usuario) throws DAOException {
	}

	@Override
	public void modificar(Usuario usuario) throws DAOException {
	}

	@Override
	public long buscar(Usuario usuario) throws DAOException, IOException {
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
            	
            	LogAnother.getInstance().logSentence("los datos son:"+usuario.getNombre());
            	conn.close();
            	return ENCONTRADO;
            }else{
            	conn.close();
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
        	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	ex.printStackTrace();
            return NO_ENCONTRADO;
        }
	}

	@Override
	public List<Usuario> listarTodos() throws DAOException {
		return null;
	}

}
