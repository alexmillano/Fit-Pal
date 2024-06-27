package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import Interfaces.CuotaRepository;
import Modelo.Cliente;
import Modelo.Cuota;


public class CuotaControlador implements CuotaRepository{
	private final Connection connection;
	
	
	 public CuotaControlador() {
	       this.connection = DatabaseConnection.getInstance().getConnection();
	   }


	@Override
	public List<Cuota> getAllCuota() {
		List<Cuota> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cuota ");
            ResultSet resultSet = statement.executeQuery();
       
            while (resultSet.next()) {
            	 int metodo = resultSet.getInt("ID_Metodo");
                 int clienteId = resultSet.getInt("ID_Cliente");
                 double valor = resultSet.getDouble("Valor");
                 Timestamp vencimientoTimestamp = resultSet.getTimestamp("vencimiento");
                 LocalDate vencimiento = vencimientoTimestamp.toLocalDateTime().toLocalDate();

                 Cuota user = new Cuota(clienteId, valor, metodo, vencimiento);
                 users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
	}


	@Override
	public Cuota getCuotaById(int idCuota) {
		Cuota cuota = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT ID_Metodo, ID_Cliente, Valor, vencimiento FROM cuota WHERE ID_Cliente = ?");
            statement.setInt(1, idCuota);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	int metodo = resultSet.getInt("ID_Metodo");
            	int clienteId = resultSet.getInt("ID_Cliente");
                double valor = resultSet.getDouble("Valor");
                Timestamp vencimientoTimestamp = resultSet.getTimestamp("vencimiento");
                LocalDate vencimiento = vencimientoTimestamp.toLocalDateTime().toLocalDate();
                
                cuota = new Cuota(clienteId, valor, metodo, vencimiento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cuota;
	}


	@Override
	public void addCuota(Cuota cuota, int clienteID) {
		  try {
		        String sqlCuota = "INSERT INTO cuota (valor, metodo, vencimiento) VALUES (?, ?, ?)";
		        PreparedStatement statementCuota = connection.prepareStatement(sqlCuota, Statement.RETURN_GENERATED_KEYS);
		        statementCuota.setDouble(1, cuota.getValor());
		        statementCuota.setInt(2, cuota.getMetodo());
		        statementCuota.setDate(3, java.sql.Date.valueOf(cuota.getVencimiento()));

		        int rowsInsertedCuota = statementCuota.executeUpdate();
		        if (rowsInsertedCuota > 0) {
		            ResultSet generatedKeysCuota = statementCuota.getGeneratedKeys();
		            if (generatedKeysCuota.next()) {
		                int cuotaID = generatedKeysCuota.getInt(1);
		                cuota.setID_Cuota(cuotaID);
		                System.out.println("Cuota insertada exitosamente con ID: " + cuotaID);

		                // Actualizar el cliente con el nuevo ID_Cuota
		                String sqlUpdateCliente = "UPDATE cliente SET ID_Cuota = ? WHERE ID_Cliente = ?";
		                PreparedStatement statementUpdateCliente = connection.prepareStatement(sqlUpdateCliente);
		                statementUpdateCliente.setInt(1, cuotaID);
		                statementUpdateCliente.setInt(2, clienteID);

		                int rowsUpdatedCliente = statementUpdateCliente.executeUpdate();
		                if (rowsUpdatedCliente > 0) {
		                    System.out.println("Cliente actualizado con el nuevo ID_Cuota.");
		                } else {
		                    System.out.println("Fallo al actualizar el cliente con el nuevo ID_Cuota.");
		                }
		            } else {
		                System.out.println("Fallo al obtener el ID de la cuota insertada.");
		            }
		        } else {
		            System.out.println("No se insertó ninguna fila en la tabla cuota.");
		        }
		    } catch (SQLException e) {
		        System.out.println("Error al agregar cuota: " + e.getMessage());
		        e.printStackTrace();
		    }
		
	}


	@Override
	public void updateCuota(Cuota cuota) {
		try {
		PreparedStatement statement = connection.prepareStatement("UPDATE users SET ID_Metodo = ?, ID_Cliente = ? WHERE id = ?");
        statement.setInt(1, cuota.getMetodo());
        statement.setInt(3, cuota.getCliente());
        statement.setInt(6, cuota.getID_Cuota());

        
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Cuota actualizado correctamente");
        }
        
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
	}	


	@Override
	public void deleteCuota(int idCuota) {
		try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM cuota WHERE ID_Cuota = ?");
            statement.setInt(1, idCuota);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Cuota eliminada exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	  
}
