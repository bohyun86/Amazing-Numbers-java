package numbers.check;

public class Palindromic extends Check {

    public Palindromic() {
        super.setName("palindromic");
    }

    public boolean check(long num) {
        String numStr = String.valueOf(num);
        return numStr.contentEquals(new StringBuilder(numStr).reverse());
    }
}
