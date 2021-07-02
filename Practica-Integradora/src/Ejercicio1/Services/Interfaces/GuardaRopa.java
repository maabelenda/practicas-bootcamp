package Ejercicio1.Services.Interfaces;

import Ejercicio1.Entities.Prenda;
import Ejercicio1.Exceptions.ErrorException;

import java.util.List;

public interface GuardaRopa {
    Integer guardarPrendas(List<Prenda> listaDePrenda) throws ErrorException;
    void mostrarPrendas();
    List<Prenda> devolverPrendas(Integer numero) throws ErrorException;
}
