package numbers.check;

public class Buzz extends Check {

    public Buzz() {
        super.setName("buzz");
    }

    @Override
    public boolean check(long number) {
        return number % 7 == 0 || number % 10 == 7;
    }

}
