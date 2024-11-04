package numbers;

public class Main {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        NumbersList numbersList = new NumbersList();

        CheckNumber checkNumber = new CheckNumber(inputHandler, new NumberChecker(numbersList.getCheckableList()));
        checkNumber.start();
        
    }
}

