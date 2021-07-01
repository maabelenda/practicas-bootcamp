package Utils;

public class Timer {

    private long timeInitial;
    private long timeFinal;
    private long timeElapsed;

    public Timer() {

    }

    public void startTimer() {
        timeInitial = System.nanoTime();
    }

    public void stopTimer() {
        timeFinal = System.nanoTime();
        System.out.println("timeInitial: " + timeFinal);
        System.out.println("timeFinal: " + timeFinal);
        timeElapsed = (timeFinal - timeInitial);
        System.out.println("timeElapsed: " + timeElapsed + "\n");
    }
}
