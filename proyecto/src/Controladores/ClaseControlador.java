package Controladores;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Interfaces.ClaseRepository;
import Modelo.Clase;

public class ClaseControlador implements ClaseRepository{
	private final Connection connection;
	
	
	  public ClaseControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }


	@Override
	public List<Clase> getAllClase() {
	    List<Clase> clases = new ArrayList<>();
	    try {
	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM clases");
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int idClases = resultSet.getInt("ID_Clases");
	            int idProfesor = resultSet.getInt("ID_Profesor");
	            String nombre = resultSet.getString("Nombre");
	            LocalDateTime inicio = resultSet.getTimestamp("inicio").toLocalDateTime();
	            LocalDateTime fin = resultSet.getTimestamp("fin").toLocalDateTime();
	            int idNivel = resultSet.getInt("ID_Nivel");

	            System.out.println("ID_Clases: " + idClases + ", ID_Profesor: " + idProfesor + ", Nombre: " + nombre + ", Inicio: " + inicio + ", Fin: " + fin + ", ID_Nivel: " + idNivel);

	            Clase clase = new Clase(idClases, idProfesor, nombre, inicio, fin, idNivel);
	            clases.add(clase);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return clases;
	}


	@Override
	public Clase getClaseById(int id) {
		Clase clase = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM clases WHERE ID_Clases = ?");
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	clase = new Clase(resultSet.getInt("ID_Profesor"), id, resultSet.getString("Nombre"), resultSet.getTimestamp("inicio").toLocalDateTime(), resultSet.getTimestamp("fin").toLocalDateTime(), resultSet.getInt("ID_Nivel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clase;

	}


	@Override
	public boolean addClase(int profesorId, String nombre, LocalTime inicio, LocalTime fin, int nivel) {
		boolean clasecreada = false;
		try {
        	PreparedStatement statement = connection.prepareStatement("INSERT INTO clases(ID_Profesor, ID_Nivel, Nombre, inicio, fin) "
        			+ "VALUES (?,?,?,?,?)");
        	statement.setInt(1, profesorId);
        	statement.setInt(2, nivel);
        	statement.setString(3, nombre);
        	 LocalDateTime inicioDateTime = LocalDateTime.of(LocalDate.now(), inicio);
             LocalDateTime finDateTime = LocalDateTime.of(LocalDate.now(), fin);
             statement.setTimestamp(4, Timestamp.valueOf(inicioDateTime));
             statement.setTimestamp(5, Timestamp.valueOf(finDateTime));

        int rowsInserted = statement.executeUpdate();
        	if (rowsInserted > 0) {
            System.out.println("Clase insertada exitosamente");
            clasecreada=true;
        	}
        	} catch (SQLException e) {
        		System.out.println("Error al agregar clase: " + e.getMessage());
        		e.printStackTrace();
        		clasecreada=false;
        	}
		return clasecreada;
	}


	@Override
	public boolean updateClase(int profesorId, String nombre, LocalTime inicio, LocalTime fin, int nivel, int ID_Clases) {
		boolean actualizar = false;
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE clases SET ID_Profesor = ?, ID_Nivel = ?, Nombre = ?, inicio = ?, fin = ? WHERE ID_Clases = ?");
			statement.setInt(1, profesorId);
	        statement.setInt(2, nivel);
	        statement.setString(3, nombre);
	        statement.setTimestamp(4, Timestamp.valueOf(inicio.atDate(LocalDate.now())));
	        statement.setTimestamp(5, Timestamp.valueOf(fin.atDate(LocalDate.now())));
	        statement.setInt(6, ID_Clases);

	        
	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Clase actualizada correctamente");
	            actualizar = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        actualizar = false;
	    }
		return actualizar;
		
	}


	@Override
	public boolean deleteClase(int idClase) {
		boolean claseborrada = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM clases WHERE ID_Clases = ?");
            statement.setInt(1, idClase);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Clase eliminada exitosamente");
                claseborrada = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            claseborrada = false;
        }
        return claseborrada;
		
	}

}
