package Entity;

public class Counter {

    private long count;

    public Counter() {
        this.count = 0;
    }

    public Counter(long count) {
        this.count = count;
    }

    public Counter(Counter counter) {
        if(counter == null) {

        }
        this.count = counter.count;
    }

    public void increase(long value) {
        if(value <= 0) {

        }
        this.count += value;
    }

    public void decrease(long value) {
        if(value <= 0) {

        }
        this.count -= value;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
