import Utils.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;

public class Main2 {

    public static void main(String [] args) {

        try {
            Timer timer = new Timer();
            SecureRandom sr = new SecureRandom();
            sr.setSeed(10L);
            int max = 100000;
            Integer [] integers = new Integer[max];
            int i = 0;
            while (i < max) {
                integers[i] = sr.nextInt();
                i++;
            }

            Sorter<Integer> sorter = (Sorter) MiFactory.getInstance("sorter");

            timer.startTimer();

            sorter.sort(integers, (o1, o2) -> o1.compareTo(o2));

            timer.stopTimer();

            //System.out.println(Arrays.toString(integers));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
