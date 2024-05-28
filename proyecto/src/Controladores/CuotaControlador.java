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
            PreparedStatement statement = connection.prepareStatement("SELECT ID_Metodo, ID_Cliente, Valor, vencimiento FROM users WHERE id = ?");
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
	public void addCuota(Cliente cliente, Cuota cuota) {
		try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO cuotas (cliente_id, valor, metodo, vencimiento) VALUES (?, ?, ?, ?)"
            );
            statement.setInt(1, cliente.getID_Cliente());
            statement.setDouble(2, cuota.getValor());
            statement.setInt(3, cuota.getMetodo());
            LocalDate vencimiento = cuota.getVencimiento();
            LocalDateTime vencimientoDateTime = vencimiento.atStartOfDay();
            Timestamp vencimientoTimestamp = Timestamp.valueOf(vencimientoDateTime);
            statement.setTimestamp(4, vencimientoTimestamp);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Cuota insertada exitosamente");
            }
        } catch (SQLException e) {
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
