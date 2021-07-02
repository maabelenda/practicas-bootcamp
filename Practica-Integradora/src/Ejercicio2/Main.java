package Ejercicio2;



import Ejercicio2.Entities.Car;
import Ejercicio2.Entities.Interfaces.Race;
import Ejercicio2.Entities.RaceImpl;
import Ejercicio2.Exceptions.ErrorException;

public class Main {

    public static void main(String[] args) {

        Race race = new RaceImpl(125.5, 10000, "Dakar", 10);

        try {
            race.darDeAltaAuto(100,80, 1,"abc123");
            race.darDeAltaAuto(120,60, 3,"aaa123");
            race.darDeAltaAuto(130,80, -1,"bbb123");

            race.darDeAltaMoto(70,80, 1,"ccc123");
            race.darDeAltaMoto(80,70, 2,"ddd123");
            race.darDeAltaMoto(80,85, 1,"eee123");

            race.eliminarVehiculo(new Car(120,60,3,"aaa123"));
            race.eliminarVehiculoConPatente("eee123");
            race.helpCar("abc123");

            race.helpMotorcycle("ccc123");
            race.calculateWinner();

        } catch (ErrorException e) {
            e.printStackTrace();
        }


    }

}
