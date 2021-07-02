package Ejercicio3.Entities;

public class MeliGuest extends Guest {

    private static final String PHRASE = "Viva la Chiqui";

    public MeliGuest(String name) {
        super(name);
    }

    public void sayPhrase() {
        System.out.println(PHRASE);
    }
}
