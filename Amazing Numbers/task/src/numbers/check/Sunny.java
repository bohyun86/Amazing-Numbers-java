package numbers.check;

public class Sunny extends Check {

    public Sunny() {
        this.setName("sunny");
    }

    @Override
    public boolean check(long number) {
        double sqrt = Math.sqrt(number + 1);
        return sqrt == (int) sqrt;
    }
}
