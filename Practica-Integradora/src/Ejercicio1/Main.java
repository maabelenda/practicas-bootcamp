package Ejercicio1;

import Ejercicio1.Entities.Prenda;
import Ejercicio1.Exceptions.ErrorException;
import Ejercicio1.Services.GuardaRopaImpl;
import Ejercicio1.Services.Interfaces.GuardaRopa;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Prenda p1 = new Prenda("Nike", "gorra");
        Prenda p2 = new Prenda("Addidas", "campera");
        List<Prenda> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);

        Prenda p3 = new Prenda("Nike", "short");
        Prenda p4 = new Prenda("Addidas", "remera");
        List<Prenda> list1 = new ArrayList<>();
        list1.add(p3);
        list1.add(p4);

        GuardaRopa guardaRopa = new GuardaRopaImpl();

        try {
            Integer number = guardaRopa.guardarPrendas(list);

            guardaRopa.guardarPrendas(list1);
            guardaRopa.mostrarPrendas();
            guardaRopa.devolverPrendas(number);
            System.out.println("---------------------------------------------------");
            guardaRopa.mostrarPrendas();
        } catch ( ErrorException e) {
            e.printStackTrace();
        }

    }
}
