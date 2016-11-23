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

import prograavanzada2016.anotherworld.modelos.PersonajeModel;

public class PersonajeDAO extends DAO<PersonajeModel> {
	
	private Statement statement;
	private Connection conn;
    private static final int NO_ENCONTRADO = -1;
    private static final int ENCONTRADO = 1;
    
    public PersonajeDAO(Connection conn, Statement stat) throws SQLException, FileNotFoundException, IOException{
    	try {
			Class.forName("org.sqlite.JDBC");
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\resources\\cfg.properties"));
			//conn = DriverManager.getConnection(System.getProperty("user.dir") +"\\src\\main\\resources\\jrpg.sqlite"); //solo cambiar esto :)
			//mati
			//conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\matut\\jrpg\\servidor\\src\\main\\java\\prograavanzada2016\\anotherworld\\DAO\\jrpg.sqlite");
			//agus
			//conn = DriverManager.getConnection("jdbc:sqlite:C:\\GitAvanzada\\PrograAvanzada\\jrpg\\servidor\\src\\main\\java\\prograavanzada2016\\anotherworld\\DAO\\jrpg.sqlite");
			//lukki
			//conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\lukki\\Desktop\\JuegoProgra\\jrpg\\servidor\\src\\main\\java\\prograavanzada2016\\anotherworld\\DAO\\jrpg.sqlite");
			//martin
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\lukki\\Desktop\\JuegoProgra\\jrpg\\servidor\\src\\main\\java\\prograavanzada2016\\anotherworld\\DAO\\jrpg.sqlite");
			conn.setAutoCommit(false);
			statement = conn.createStatement();
			stat = statement;
			this.conn=conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public boolean insertar(PersonajeModel pm) throws DAOException {
        try {
			int size = 0;
			String count = "select * from personaje";
			ResultSet rs = statement.executeQuery(count);
			
			while (rs.next()) {
			    size++;
			}
			size++;
			rs.close();
			
			PreparedStatement statement = conn.prepareStatement(
			        "INSERT INTO 'main'.'personaje' VALUES ("+size+",'"+pm.getUsuarioId()+"','"+pm.getCastaId()+"','"+pm.getRazaId()+"','"+pm.getNombre()+"','"+pm.getFuerza()+"','"+pm.getDestreza()+"','"+pm.getInteligencia()+"','"+pm.getMana()+"','"+pm.getEnergia()+"','"+pm.getNivel()+"','"+pm.getSalud()+"','"+pm.getExperiencia()+"')");
					statement.executeUpdate();
					conn.commit();
					conn.close();
					 return true;
		    
		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}


	@Override
	public long buscar(PersonajeModel personajeModel) throws DAOException {
		try {
			String buscar = "SELECT * FROM personaje where usuario_idUsuario = '"+personajeModel.getUsuarioId()+"';";
			statement.execute(buscar);
			ResultSet rs = statement.executeQuery(buscar);
			if(rs.next()){
				personajeModel.setId(rs.getInt("idpersonaje"));
				personajeModel.setUsuarioId(rs.getInt("usuario_idUsuario"));
				personajeModel.setCastaId(rs.getInt("casta_idcasta"));
				personajeModel.setRazaId(rs.getInt("raza_idraza"));
				personajeModel.setNombre(rs.getString("nombre"));
				personajeModel.setFuerza(rs.getInt("fuerza"));
				personajeModel.setDestreza(rs.getInt("destreza"));
				personajeModel.setInteligencia(rs.getInt("inteligencia"));
				personajeModel.setMana(rs.getInt("mana"));
				personajeModel.setEnergia(rs.getInt("energia"));
				personajeModel.setNivel(rs.getInt("nivel"));
				personajeModel.setSalud(rs.getInt("salud"));
				personajeModel.setExperiencia(rs.getInt("experiencia"));
				/*personaje = new PersonajeModel(rs.getInt("idpersonaje"),rs.getInt("usuario_idUsuario"),rs.getInt("casta_idcasta"),
            			rs.getInt("raza_idraza"),rs.getString("nombre"),rs.getInt("fuerza"),rs.getInt("destreza"),rs.getInt("inteligencia"),
            			rs.getInt("mana"),rs.getInt("energia"),rs.getInt("nivel"),rs.getInt("salud"),rs.getInt("experiencia"));*/
				conn.close();
			}
				else{
					conn.close();
					return NO_ENCONTRADO;
				}		
		}catch (SQLException ex) {
	    	ex.printStackTrace();
	        return NO_ENCONTRADO;
	    }
		
		return ENCONTRADO;
		}

	@Override
	public void borrar(PersonajeModel obj) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(PersonajeModel obj) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonajeModel> listarTodos() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
