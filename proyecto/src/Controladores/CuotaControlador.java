package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Cuota getCuotaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addCuota(Cliente cliente, Cuota cuota) {
		try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO cuotas (cliente_id, valor, metodo, vencimiento) VALUES (?, ?, ?, ?)"
            );
            statement.setInt(1, cliente.getID_Cliente());
            statement.setDouble(2, cuota.getValor());
            statement.setString(3, cuota.getMetodo());
            statement.setTimestamp(4, java.sql.Timestamp.valueOf(cuota.getVencimiento()));

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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteCuota(int id) {
		// TODO Auto-generated method stub
		
	}
	  
}
