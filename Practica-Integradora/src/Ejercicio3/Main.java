package Ejercicio3;


import Ejercicio3.Entities.*;
import Ejercicio3.Exceptions.ErrorException;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Guest> guests = new ArrayList<>();

        Guest g1 = new Guest("Pepe");
        Guest g2 = new Guest("Jorge");
        MeliGuest m1 = new MeliGuest("Raul");
        MeliGuest m2 = new MeliGuest("Marcelo");
        guests.add(g1);
        guests.add(g2);
        guests.add(m1);
        guests.add(m2);

        IndividualFirework f1 = new IndividualFirework(1,()->System.out.println("booom!"));

        IndividualFirework f2 = new IndividualFirework(2,()->System.out.println("blum!"));
        IndividualFirework f3 = new IndividualFirework(3,()->System.out.println("phiii pum!"));
        FireworkPack p1 = new FireworkPack(4);
        try {
            p1.addFirework(f1);
            p1.addFirework(f2);
            FireworkPack p2 = new FireworkPack(5);
            p2.addFirework(p1);
            p2.addFirework(f3);guests.forEach((g) -> g.sayPhrase());
            p2.exploit();
        } catch (ErrorException e) {
            e.printStackTrace();
        }





    }
}
