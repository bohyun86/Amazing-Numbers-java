package numbers.check;

public class Spy extends Check {

    public Spy() {
        this.setName("spy");
    }

    @Override
    public boolean check(long num) {
        String str = String.valueOf(num);
        int sum = 0;
        int product = 1;
        for (int i = 0; i < str.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(str.charAt(i)));
            sum += digit;
            product *= digit;
        }
        return sum == product;
    }

}
