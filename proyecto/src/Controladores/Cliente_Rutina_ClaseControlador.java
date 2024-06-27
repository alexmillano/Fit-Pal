package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Interfaces.Cliente_Rutina_ClaseRepository;
import Modelo.Cliente_Rutina_Clase;
import Modelo.Ejercicio;

public class Cliente_Rutina_ClaseControlador implements Cliente_Rutina_ClaseRepository{
    private final Connection connection;

    public Cliente_Rutina_ClaseControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

	@Override
	public List<Cliente_Rutina_Clase> getAllClienteRutinaClase() {
	     List<Cliente_Rutina_Clase> lista = new ArrayList<>();
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente_rutina_clase");
	            ResultSet resultSet = statement.executeQuery();
	       
	            while (resultSet.next()) {
	            	Cliente_Rutina_Clase intermedia = new Cliente_Rutina_Clase(resultSet.getInt("ID_Cliente") ,resultSet.getInt("ID_Rutinas"),resultSet.getInt("ID_Clases"));
	            	lista.add(intermedia);
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return lista;
	}

	@Override
	public Cliente_Rutina_Clase getClienteRutinaClaseById(int ID_Cliente, int ID_Rutina, int ID_Clase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addClienteRutinaClase(Cliente_Rutina_Clase Cliente_Rutina_Clase) {
		try {
        	PreparedStatement statement = connection.prepareStatement("INSERT INTO cliente_rutina_clase(ID_Cliente, ID_Rutinas, ID_Clases) "
        			+ "VALUES (?,?,?)");
        	statement.setInt(1, Cliente_Rutina_Clase.getID_Cliente());
        	statement.setInt(2, Cliente_Rutina_Clase.getID_Rutina());
        	statement.setInt(3, Cliente_Rutina_Clase.getID_Clase());

        
        int rowsInserted = statement.executeUpdate();
        	if (rowsInserted > 0) {
            System.out.println("cliente_rutina_clases insertada exitosamente");
        	}
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
		
	}

	@Override
	public void updateClase(Cliente_Rutina_Clase Cliente_Rutina_Clase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClase(int ID_Cliente,  int ID_Clase) {
		 try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM cliente_rutina_clase WHERE ID_Cliente  = ?  AND ID_Clases = ?");
	            statement.setInt(1, ID_Cliente);
	            statement.setInt(2, ID_Clase);

	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Clase intermedia eliminado exitosamente");
	            }
	        } catch (SQLException e) {
	        	System.out.println("Error en los datos ingresados o la clase intermedia no existe");
	            e.printStackTrace();
	        }
		
		
	}
    
    
}
