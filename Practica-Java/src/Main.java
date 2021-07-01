public class Main {
    public static void main(String [] args) {

        //exerciseOne(args);
        //exerciseTwo(args);
        //exerciseThree(args);
        //exerciseFour(args);
        exerciseFive(args);

    }

    public static void exerciseOne(String [] args) {

        int n;

        try {
            n = Integer.valueOf(args[0]);
        } catch (Exception e) {
            System.out.println("Error de argumentos");
            return;
        }

        int print = 0;
        System.out.println("Los primeros " + n + " números pares son: ");
        for(int i = 0 ; i < n ; i++) {
            print += 2;
            System.out.println(print);
        }

    }

    public static void exerciseTwo(String [] args) {

        int n;
        int m;

        try {
            n = Integer.valueOf(args[0]);
            m = Integer.valueOf(args[1]);

        } catch (Exception e) {
            System.out.println("Error de argumentos");
            return;
        }

        int print = 0;
        System.out.println("Los números múltiplos de " + n + " son: ");
        for(int i = 0 ; i < n ; i++) {
            print += m;
            System.out.println(print);
        }

    }

    public static void exerciseThree(String [] args) {


        int n;

        try {
            n = Integer.valueOf(args[0]);
        } catch (Exception e) {
            System.out.println("Error de argumentos");
            return;
        }

        if(isPrime(n)){
            System.out.println(n + " es primo");
        } else {
            System.out.println(n + " no es primo");
        }


    }

    public static void exerciseFour(String [] args) {


        int n;

        try {
            n = Integer.valueOf(args[0]);
        } catch (Exception e) {
            System.out.println("Error de argumentos");
            return;
        }

        int count = 0;
        int possiblePrime = 1;
        System.out.println("Los primeros " + n + " primos son: ");
        while(count < n) {
            if(isPrime(possiblePrime)) {
                count++;
                System.out.println(possiblePrime);
            }
            possiblePrime++;
        }

    }

    public static void exerciseFive(String [] args) {

        int n;
        int m;
        int d;

        try {
            n = Integer.valueOf(args[0]);
            m = Integer.valueOf(args[1]);
            d = Integer.valueOf(args[2]);
        } catch (Exception e) {
            System.out.println("Error de argumentos");
            return;
        }

        int count = 0;
        int candidate = 0;

        for(int i = 0; i < m ; i++) {
            candidate += (Math.pow(10,i))*d;
        }

        System.out.println("Los números que cumplen la condición son: ");
        while(count < n) {
            if(isCandidate(candidate, m, d)) {
                System.out.println(candidate);
                count++;
            }
            candidate += 1;
        }

    }

    public static boolean isCandidate(int num, int m, int d) {

        int aux = num;
        int count = 0;
        while(aux > 0) {

            int aux1 = aux % 10;
            aux = aux/10;
            if(d == aux1) {
                count++;
            }
            if(count > m) {
                return false;
            }
        }

        return count == m ? true : false;
    }

    public static boolean isPrime(int n) {

        int count = 0;
        for(int i = 1 ; i <= n ; i ++) {
            if(n % i == 0) {
                count++;
            }
            if(count > 2) {
                return false;
            }
        }

        return true;
    }
}
