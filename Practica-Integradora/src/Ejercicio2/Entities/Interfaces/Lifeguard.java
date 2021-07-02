package Ejercicio2.Entities.Interfaces;

import Ejercicio2.Entities.Vehicle;

public interface Lifeguard<T extends Vehicle> {
    void help(T vehicle);
}
