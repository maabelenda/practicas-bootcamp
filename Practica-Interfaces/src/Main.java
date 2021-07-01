import Entities.Celular;
import Entities.Persona;
import Entities.Precedable;
import Utils.SortUtil;

import java.util.Objects;

public class Main {

    public static void main(String [] args) {


        Persona p1 = new Persona("Pepe", 1010);
        Persona p2 = new Persona("Pepe2", 100);
        Persona p3 = new Persona("Pepe3", 3010);

        /*
        Precedable<Persona> [] personas = new Precedable[]{p1, p2, p3};

        Persona[] personita={new Persona("Pablo",1)
                ,new Persona("Juan",2)
                ,new Persona("Alberto",3)
                ,new Persona("Raul",4)};

        SortUtil.ordenar(personita);

        if(Objects.nonNull(personas)) {

        }


        SortUtil.print(personas);
        SortUtil.ordenar(personas);

        System.out.println("array ordenado: ");
        SortUtil.print(personas);
        */

        Celular c1 = new Celular(p1, 3000);
        Celular c2 = new Celular(p2, 2000);
        Celular c3 = new Celular(p1, 1000);

        Precedable<Persona> [] celulares = new Precedable[]{c1, c2, c3};

        SortUtil.print(celulares);
        SortUtil.ordenar(celulares);

        System.out.println("array ordenado: ");
        SortUtil.print(celulares);


    }
}
