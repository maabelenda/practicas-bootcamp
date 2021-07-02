package Ejercicio2.Entities;

public class Motorcycle extends Vehicle {

    private static double WEIGHT = 300.0;
    private static int WHEELS = 2;

    public Motorcycle(double velocity, double acceleration, double turningAngle, String licensePlate) {
        super(velocity, acceleration, turningAngle, licensePlate, WEIGHT, WHEELS);
    }

}
