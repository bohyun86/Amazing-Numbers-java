package numbers.check;

public class Square extends Check {

    public Square() {
        this.setName("square");
    }

    @Override
    public boolean check(long number) {
        double sqrt = Math.sqrt(number);
        return sqrt == (int) sqrt;
    }
}
