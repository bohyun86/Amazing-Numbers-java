package numbers.check;

public abstract class Check implements Checkable {
    private String name = "Check";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean check(long num);

}
