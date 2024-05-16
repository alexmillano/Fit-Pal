package Interfaces;

import java.util.List;

import Modelo.Ejercicio;

public interface EjercicioRepository {

    List<Ejercicio> getAllEjercicio(); // llama a todos los ejercicio de la bdd
    
    Ejercicio getEjercicioById(int id); //llama solo a uno, por su id
    
    void addEjercicio(Ejercicio ejercicio); //añade ejercicio a la bdd
    
    void updateEjercicio(Ejercicio ejercicio); //actualiza los ejercicio de la bdd
    
    void deleteEjercicio(int id); //eliminar ejercicio de la bdd
}
