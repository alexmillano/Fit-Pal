package Interfaces;

import java.util.List;

import Modelo.Cuota;

public interface CuotaRepository {
List<Cuota> getAllCuota(); // llama a todos las clientes de la bdd
    
    Cuota getCuotaById(int id); //llama solo a uno, por su id
    
    void addCuota(Cuota cuota); //añade clase a la bdd
    
    void updateCuota(Cuota cuota); //actualiza las clase de la bdd
    
    void deleteCuota(int id); //eliminar clase de la bdd
}
