package numbers.check;

public class Jumping extends Check {

    public Jumping() {
        this.setName("jumping");
    }

    @Override
    public boolean check(long number) {
        String num = String.valueOf(number);
        for (int i = 0; i < num.length() - 1; i++) {
            if (Math.abs(num.charAt(i) - num.charAt(i + 1)) != 1) {
                return false;
            }
        }
        return true;
    }
}
