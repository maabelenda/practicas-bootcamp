package Ejercicio1.Services;


import Ejercicio1.Entities.Prenda;
import Ejercicio1.Exceptions.ErrorException;
import Ejercicio1.Services.Interfaces.GuardaRopa;
import Ejercicio1.Utils.ErrorMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GuardaRopaImpl implements GuardaRopa {

    private Map<Integer, List<Prenda>> guardaRopa;
    private Integer indice;

    public GuardaRopaImpl() {
        guardaRopa = new HashMap<>();
        this.indice = 0;
    }


    @Override
    public Integer guardarPrendas(List<Prenda> listaDePrenda) throws ErrorException {
        if(Objects.isNull(listaDePrenda) || listaDePrenda.isEmpty()) {
            throw new ErrorException(ErrorMessage.NULL_PRENDAS.getMessage(), ErrorMessage.NULL_PRENDAS.getCode());
        }

        guardaRopa.put(indice, listaDePrenda);

        return indice++;
    }

    @Override
    public void mostrarPrendas() {
        guardaRopa.forEach((i, p) -> System.out.println("Numero " + i + ": " + p));
    }

    @Override
    public List<Prenda> devolverPrendas(Integer numero) throws ErrorException {
        if(!guardaRopa.containsKey(numero)) {
            throw new ErrorException(ErrorMessage.NOT_FOUND_PRENDAS.getMessage(), ErrorMessage.NOT_FOUND_PRENDAS.getCode());
        }

        return guardaRopa.remove(numero);
    }
}
