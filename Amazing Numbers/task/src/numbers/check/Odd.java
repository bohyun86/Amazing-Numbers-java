package numbers.check;

public class Odd extends Check {

    public Odd() {
        super.setName("odd");
    }

    public boolean check(long num) {
        return num % 2 != 0;
    }
}
