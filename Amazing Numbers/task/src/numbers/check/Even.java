package numbers.check;

public class Even extends Check {

    public Even() {
        super.setName("even");
    }

    public boolean check(long num) {
        return num % 2 == 0;
    }
}
