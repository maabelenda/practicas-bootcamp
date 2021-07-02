package Ejercicio2.Entities;

import java.io.Serializable;
import java.util.Objects;

public abstract class Vehicle implements Serializable {

    private double velocity;
    private double acceleration;
    private double turningAngle;
    private String licensePlate;
    private double weight;
    private int wheels;

    public Vehicle(double velocity, double acceleration, double turningAngle, String licensePlate, double weight, int wheels) {
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.turningAngle = turningAngle;
        this.licensePlate = licensePlate;
        this.weight = weight;
        this.wheels = wheels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(licensePlate, vehicle.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate);
    }

    @Override
    public String toString() {
        return "Vehicle: { " +
                "velocity: " + velocity +
                ", acceleration: " + acceleration +
                ", turningAngle: " + turningAngle +
                ", licensePlate: '" + licensePlate + '\'' +
                ", weight: " + weight +
                ", wheels: " + wheels +
                '}';
    }

    public double getPerformance() {
        return this.velocity * (0.5) * this.acceleration /
                (this.turningAngle * (this.wheels - this.weight * 100));
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getTurningAngle() {
        return turningAngle;
    }

    public void setTurningAngle(double turningAngle) {
        this.turningAngle = turningAngle;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}
