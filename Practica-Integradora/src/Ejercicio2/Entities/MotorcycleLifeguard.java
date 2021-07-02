package Ejercicio2.Entities;

import Ejercicio2.Entities.Interfaces.Lifeguard;

public class MotorcycleLifeguard<Motorcycle extends Vehicle> extends Vehicle implements Lifeguard<Motorcycle> {


    public MotorcycleLifeguard(double velocity, double acceleration, double turningAngle, String licensePlate, double weight, int wheels) {
        super(velocity, acceleration, turningAngle, licensePlate, weight, wheels);
    }

    @Override
    public void help(Motorcycle vehicle) {
        System.out.println("Socorriendo moto " + vehicle.getLicensePlate());
    }
}
