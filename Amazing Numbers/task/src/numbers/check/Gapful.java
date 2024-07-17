package numbers.check;

public class Gapful extends Check {

    public Gapful() {
        this.setName("gapful");
    }

    @Override
    public boolean check(long num) {
        if (num < 100) {
            return false;
        }
        String strNum = String.valueOf(num);
        String divisor = strNum.charAt(0) + "" + strNum.charAt(strNum.length() - 1);
        return num % Long.parseLong(divisor) == 0;
    }

}
