package Ejercicio2.Entities;

import Ejercicio2.Entities.Interfaces.Race;
import Ejercicio2.Exceptions.ErrorException;
import Ejercicio2.Utils.ErrorMessage;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class RaceImpl implements Race {
    private double distance;
    private double prizeInDollars;
    private String name;
    private int amountOfVehiclesAllowed;
    private Map<String ,Vehicle> vehicleList;
    private CarLifeguard carLifeguard;
    private MotorcycleLifeguard motorcycleLifeguard;

    public RaceImpl(double distance, double prizeInDollars, String name, int amountOfVehiclesAllowed) {
        this.distance = distance;
        this.prizeInDollars = prizeInDollars;
        this.name = name;
        this.amountOfVehiclesAllowed = amountOfVehiclesAllowed;
        this.vehicleList = new HashMap<>();
        this.carLifeguard = new CarLifeguard(60,10,1,"car",2000.0,4);
        this.motorcycleLifeguard = new MotorcycleLifeguard(60,10,1,"moto",1000.0,4);

    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrizeInDollars() {
        return prizeInDollars;
    }

    public void setPrizeInDollars(double prizeInDollars) {
        this.prizeInDollars = prizeInDollars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfVehiclesAllowed() {
        return amountOfVehiclesAllowed;
    }

    public void setAmountOfVehiclesAllowed(int amountOfVehiclesAllowed) {
        this.amountOfVehiclesAllowed = amountOfVehiclesAllowed;
    }

    public Collection<Vehicle> getVehicleList() {
        return vehicleList.values();
    }

    @Override
    public void darDeAltaAuto(double velocity, double acceleration, double turningAngle, String licensePlate) throws ErrorException {
        if(velocity <= 0 || acceleration <= 0 || turningAngle < -20.0 || turningAngle == 0 || turningAngle > 20.0 ||
                Objects.isNull(licensePlate) || licensePlate.isEmpty()) {
            throw new ErrorException(ErrorMessage.BAD_ARGUMENTS.getMessage(), ErrorMessage.BAD_ARGUMENTS.getCode());
        }
        if(this.vehicleList.size() == this.amountOfVehiclesAllowed) {
            throw new ErrorException(ErrorMessage.EXCEEDED_MAX_RACE_SIZE.getMessage(), ErrorMessage.NOT_FOUND_VEHICLE.getCode());
        }
        if(this.vehicleList.containsKey(licensePlate)) {
            throw new ErrorException(ErrorMessage.RACER_ALREADY_EXIST.getMessage(), ErrorMessage.RACER_ALREADY_EXIST.getCode());
        }
        Car car = new Car(velocity, acceleration, turningAngle, licensePlate);
        this.vehicleList.put(licensePlate, car);

    }

    @Override
    public void darDeAltaMoto(double velocity, double acceleration, double turningAngle, String licensePlate) throws ErrorException {
        if(velocity <= 0 || acceleration <= 0 || turningAngle <= 0 || turningAngle > 20.0 ||
                Objects.isNull(licensePlate) || licensePlate.isEmpty()) {
            throw new ErrorException(ErrorMessage.BAD_ARGUMENTS.getMessage(), ErrorMessage.BAD_ARGUMENTS.getCode());
        }
        if(this.vehicleList.size() == this.amountOfVehiclesAllowed) {
            throw new ErrorException(ErrorMessage.EXCEEDED_MAX_RACE_SIZE.getMessage(), ErrorMessage.NOT_FOUND_VEHICLE.getCode());
        }
        if(this.vehicleList.containsKey(licensePlate)) {
            throw new ErrorException(ErrorMessage.RACER_ALREADY_EXIST.getMessage(), ErrorMessage.RACER_ALREADY_EXIST.getCode());
        }
        Motorcycle motorcycle = new Motorcycle(velocity, acceleration, turningAngle, licensePlate);
        this.vehicleList.put(licensePlate, motorcycle);
    }

    @Override
    public void eliminarVehiculo(Vehicle vehicle) throws ErrorException {
        if(Objects.isNull(vehicle)) {
            throw new ErrorException(ErrorMessage.BAD_ARGUMENTS.getMessage(), ErrorMessage.BAD_ARGUMENTS.getCode());
        }
        if(!this.vehicleList.containsKey(vehicle.getLicensePlate())) {
            throw new ErrorException(ErrorMessage.NOT_FOUND_VEHICLE.getMessage(), ErrorMessage.NOT_FOUND_VEHICLE.getCode());
        }
        this.vehicleList.remove(vehicle.getLicensePlate());
    }

    @Override
    public void eliminarVehiculoConPatente(String licensePlate) throws ErrorException {
        if(Objects.isNull(licensePlate)) {
            throw new ErrorException(ErrorMessage.BAD_ARGUMENTS.getMessage(), ErrorMessage.BAD_ARGUMENTS.getCode());
        }
        if(!this.vehicleList.containsKey(licensePlate)) {
            throw new ErrorException(ErrorMessage.NOT_FOUND_VEHICLE.getMessage(), ErrorMessage.NOT_FOUND_VEHICLE.getCode());
        }
        this.vehicleList.remove(licensePlate);
    }

    @Override
    public void calculateWinner() {
        List<Vehicle> winners = new ArrayList<>();
        AtomicReference<Double> pointOfWinner = new AtomicReference<>();
        this.vehicleList.forEach((lp, v) -> {
            double acctualRacer = v.getPerformance();
            if(winners.isEmpty()) {
                pointOfWinner.set(acctualRacer);
                winners.add(v);
            } else if(pointOfWinner.get().equals(acctualRacer)) {
                winners.add(v);
            } else if(pointOfWinner.get().compareTo(acctualRacer) < 0) {
                winners.clear();
                winners.add(v);
                pointOfWinner.set(acctualRacer);
            }
        });
        if(winners.size() == 1) {
            System.out.println("El ganador es: ");
        } else {
            System.out.println("Los ganadores son: ");
        }
        System.out.println(winners);
        System.out.println("Performance: " +pointOfWinner.get());
    }

    @Override
    public void helpCar(String licensePlate) throws ErrorException {
        if(Objects.isNull(licensePlate)) {
            throw new ErrorException(ErrorMessage.BAD_ARGUMENTS.getMessage(), ErrorMessage.BAD_ARGUMENTS.getCode());
        }
        if(!this.vehicleList.containsKey(licensePlate)) {
            throw new ErrorException(ErrorMessage.NOT_FOUND_VEHICLE.getMessage(), ErrorMessage.NOT_FOUND_VEHICLE.getCode());
        }
        Vehicle vehicle = this.vehicleList.get(licensePlate);
        if(vehicle.getClass() != Car.class) {
            throw new ErrorException(ErrorMessage.BAD_LIFEGUARD.getMessage(), ErrorMessage.BAD_LIFEGUARD.getCode());
        }
        this.carLifeguard.help(vehicle);
    }

    @Override
    public void helpMotorcycle(String licensePlate) throws ErrorException {
        if(Objects.isNull(licensePlate)) {
            throw new ErrorException(ErrorMessage.BAD_ARGUMENTS.getMessage(), ErrorMessage.BAD_ARGUMENTS.getCode());
        }
        if(!this.vehicleList.containsKey(licensePlate)) {
            throw new ErrorException(ErrorMessage.NOT_FOUND_VEHICLE.getMessage(), ErrorMessage.NOT_FOUND_VEHICLE.getCode());
        }
        Vehicle vehicle = this.vehicleList.get(licensePlate);
        if(vehicle.getClass() != Motorcycle.class) {
            throw new ErrorException(ErrorMessage.BAD_LIFEGUARD.getMessage(), ErrorMessage.BAD_LIFEGUARD.getCode());
        }
        this.motorcycleLifeguard.help(vehicle);
    }
}