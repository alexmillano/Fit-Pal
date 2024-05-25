package Interfaces;

import java.util.List;

import Modelo.Cliente;
import Modelo.Cuota;

public interface CuotaRepository {
List<Cuota> getAllCuota(); // llama a todos las cuotas de la bdd
    
    Cuota getCuotaById(int id); //llama solo a uno, por su id
    
    void addCuota(Cliente cliente, Cuota cuota); //añade cuota a la bdd
    
    void updateCuota(Cuota cuota); //actualiza las cuotas de la bdd
    
    void deleteCuota(int id); //eliminar cuota de la bdd

}
