package numbers.check;

public class Sad extends Check {

    public Sad() {
        super.setName("sad");
    }

    public boolean check(long num) {
        long sum = num;
        while (sum != 1 && sum != 4) {
            long temp = sum;
            sum = 0;
            while (temp != 0) {
                sum += (temp % 10) * (temp % 10);
                temp /= 10;
            }
        }
        return sum != 1;
    }
}
