package Interfaces;

import java.util.List;

import Modelo.Usuario;
import proyecto.Cliente;

public interface UserRepository {
	//prototipos de metodos 
    List<Cliente> getAllUsers(); // llama a todos los clientes de la bdd
    
    Cliente getUserById(int id); //llama solo a uno, por su id
    
    void addUser(Cliente cliente); //añade cliente a la bdd
    
    void updateUser(Cliente cliente); //actualiza los cliente de la bdd
    
    void deleteUser(int id); //eliminar cliente de la bdd
}
