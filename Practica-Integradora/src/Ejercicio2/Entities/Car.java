package Ejercicio2.Entities;

public class Car extends Vehicle {

    private static double WEIGHT = 1000.0;
    private static int WHEELS = 4;

    public Car(double velocity, double acceleration, double turningAngle, String licensePlate) {
        super(velocity, acceleration, turningAngle, licensePlate, WEIGHT, WHEELS);
    }
}
