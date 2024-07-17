package numbers.check;

public class Duck extends Check {

    public Duck() {
        super.setName("duck");
    }

    @Override
    public boolean check(long num) {
        return String.valueOf(num).substring(1).contains("0");
    }
}
