package prograavanzada2016.anotherworld.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import prograavanzada2016.anotherworld.entities.Personaje;
import prograavanzada2016.anotherworld.modelos.PersonajeModel;
import prograavanzada2016.anotherworld.modelos.Usuario;

public class PersonajeDAO extends DAO<Usuario> {
	
	private Statement statement;
    private static final int NO_ENCONTRADO = -1;
    private static final int ENCONTRADO = 1;
    
    public PersonajeDAO(Connection conn, Statement stat) throws SQLException{
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
	public void insertar(Personaje personaje, int usuarioID) throws DAOException {
		String insert = "INSERT INT personaje (idpersonaje, usuario_idusuario, casta_idcasta, raza_idraza, nombre, fuerza, destreza, inteligencia, mana, energia, nivel, salud, experiencia) values('"+personaje.getIdEnte()+"','"+usuarioID+"','"+personaje.getCasta().getId()+"', '"+personaje.getRaza().getId()+"', '"+personaje.getNombre()+"', '"+personaje.getFuerza()+"', '"+personaje.getDestreza()+"', '"+personaje.getInteligencia()+"', '"+personaje.getMana()+"', '"+personaje.getEnergia()+"', '"+personaje.getNivel()+"', '"+personaje.getSalud()+"', '"+personaje.getExperienciaActual()+"');";
        try {
			statement.execute(insert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrar(Usuario obj) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Usuario obj) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long buscar(Usuario usuario) throws DAOException {
		try {
			PersonajeModel personaje;
			String buscar = "SELECT * FROM personaje where usuario_idUsuario = '"+usuario.getId()+"';";
			statement.execute(buscar);
			ResultSet rs = statement.executeQuery(buscar);
			if(rs.next()){
				personaje = new PersonajeModel(rs.getInt("idpersonaje"),rs.getInt("usuario_idUsuario"),rs.getInt("casta_idcasta"),
            			rs.getInt("raza_idraza"),rs.getString("nombre"),rs.getInt("fuerza"),rs.getInt("destreza"),rs.getInt("inteligencia"),
            			rs.getInt("mana"),rs.getInt("energia"),rs.getInt("nivel"),rs.getInt("salud"),rs.getInt("experiencia"));
				usuario.setPersonaje(personaje);
			}
				else{
					return NO_ENCONTRADO;
				}		
		}catch (SQLException ex) {
	    	ex.printStackTrace();
	        return NO_ENCONTRADO;
	    }
		return NO_ENCONTRADO;
		}

	@Override
	public List<Usuario> listarTodos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(Usuario obj) throws DAOException {
		return false;
		// TODO Auto-generated method stub
		
	}
	
	

}
