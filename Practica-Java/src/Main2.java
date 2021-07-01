import java.util.Scanner;

public class Main2 {

    public static void main(String [] args) {
        exerciseThree();


    }

    public static void exerciseOne() {
        System.out.println("Escribe dos números");
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        double m = scanner.nextDouble();

        System.out.println("Suma: " + (n+m));
        System.out.println("Resta: " + (n-m));
        System.out.println("Multiplicación: " + (n*m));
        System.out.println("División: " + (n/m));
        System.out.println("Módulo: " + (n%m));

    }

    public static void exerciseTwo() {
        System.out.println("Escribe tu nombre");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Bienvenido " + name);
    }

    public static void exerciseThree() {
        System.out.println("Escribe radio");
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        System.out.println("El área es " + Math.PI*Math.pow(n,2));
    }

    public static void exerciseFour() {
        System.out.println("Escribe un número");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n % 2 == 0) {
            System.out.println("Es par");
        } else {
            System.out.println("Es impar");
        }
    }
}
