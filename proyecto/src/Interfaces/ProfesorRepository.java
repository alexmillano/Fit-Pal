package Interfaces;

import java.util.List;

import Modelo.Profesor;

public interface ProfesorRepository {
List<Profesor> getAllProfesor(); // llama a todos los profesores de la bdd
    
    Profesor getProfesorById(int id); //llama solo a uno, por su id
    
    void addProfesor(Profesor profesor); //añade profesor a la bdd
    
    void updateProfesor(Profesor profesor); //actualiza los profesores de la bdd
    
    void deleteProfesor(int id); //eliminar profesor de la bdd
}
