package Interfaces;

import java.util.List;

import Modelo.Cliente_Rutina_Clase;

public interface Cliente_Rutina_ClaseRepository {

    List<Cliente_Rutina_Clase> getAllClienteRutinaClase();
    
    Cliente_Rutina_Clase getClienteRutinaClaseById(int ID_Cliente, int ID_Rutina, int ID_Clase); 
    
    void addClienteRutinaClase(Cliente_Rutina_Clase Cliente_Rutina_Clase); //añade clase a la bdd
    
    void updateClase(Cliente_Rutina_Clase Cliente_Rutina_Clase); //actualiza las clase de la bdd
    
    void deleteClase(int ID_Cliente, int ID_Rutina, int ID_Clase); //eliminar clase de la bdd
}
