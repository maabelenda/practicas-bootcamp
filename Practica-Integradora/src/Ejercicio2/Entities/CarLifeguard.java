package Ejercicio2.Entities;

import Ejercicio2.Entities.Interfaces.Lifeguard;

public class CarLifeguard<Car extends Vehicle> extends Vehicle implements Lifeguard<Car> {


    public CarLifeguard(double velocity, double acceleration, double turningAngle, String licensePlate, double weight, int wheels) {
        super(velocity, acceleration, turningAngle, licensePlate, weight, wheels);
    }

    @Override
    public void help(Car vehicle) {
        System.out.println("Socorriendo auto " + vehicle.getLicensePlate());
    }
}
