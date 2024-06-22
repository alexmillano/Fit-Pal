package Interfaces;

import java.util.List;

import Modelo.Cliente;
import Modelo.Cuota;


public interface ClienteRepository {
	//prototipos de metodos 
    List<Cliente> getAllCliente(); // llama a todos los clientes de la bdd
    
    Cliente getClienteById(int id); //llama solo a uno, por su id
    
    boolean addCliente(int ID_Cliente,String nombre, String apellido, int dni, String contraseña, String correo, int nivel, int telefono, Cuota cuota); //añade cliente a la bdd
    
    boolean updateCliente(Cliente cliente); //actualiza los cliente de la bdd
    
    boolean deleteCliente(int id); //eliminar cliente de la bdd
}
