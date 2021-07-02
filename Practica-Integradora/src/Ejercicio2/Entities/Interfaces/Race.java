package Ejercicio2.Entities.Interfaces;

import Ejercicio2.Entities.Vehicle;
import Ejercicio2.Exceptions.ErrorException;

public interface Race {

    void darDeAltaAuto(double velocity, double acceleration, double turningAngle, String licensePlate) throws ErrorException;
    void darDeAltaMoto(double velocity, double acceleration, double turningAngle, String licensePlate) throws ErrorException;
    void eliminarVehiculo(Vehicle vehicle) throws ErrorException;
    void eliminarVehiculoConPatente(String licensePlate) throws ErrorException;
    void calculateWinner();
    void helpCar(String licensePlate) throws ErrorException;
    void helpMotorcycle(String licensePlate) throws ErrorException;
}
