package numbers;

import numbers.check.Check;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CheckNumber {

    private final InputHandler inputHandler;
    private final NumberChecker numberChecker;

    public CheckNumber(InputHandler inputHandler, NumberChecker numberChecker) {
        this.inputHandler = inputHandler;
        this.numberChecker = numberChecker;
    }

    public void start() {
        printWelcomeMessage();
        processRequests();
    }

    private void printWelcomeMessage() {
        System.out.println("""
                Welcome to Amazing Numbers!
                               \s
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
                - separate the parameters with one space;
                - enter 0 to exit.""");
    }

    private void processRequests() {
        while (true) {
            String[] num = inputHandler.getInputs();
            int length = num.length;
            if (length == 1) {
                processSingleNumber(num[0]);
            } else if (length == 2) {
                processNumberRange(num[0], num[1]);
            } else {
                processNumberRangeWithProperties(num);
            }
        }
    }

    private void processSingleNumber(String input) {
        long number = Long.parseLong(input);
        if (number == 0) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
        System.out.printf("\nProperties of %,d\n", number);
        numberChecker.checkNumber(number);
    }

    private void processNumberRange(String startInput, String countInput) {
        long start = Long.parseLong(startInput);
        long count = Long.parseLong(countInput);
        for (long i = start; i < start + count; i++) {
            System.out.printf("%,d is %s\n", i, numberChecker.checkResult(i));
        }
    }

    private void processNumberRangeWithProperties(String[] inputs) {
        long start = Long.parseLong(inputs[0]);
        long count = Long.parseLong(inputs[1]);
        String[] properties = Arrays.stream(Arrays.copyOfRange(inputs, 2, inputs.length))
                .map(String::toLowerCase).toArray(String[]::new);
        NumbersList numbersList = new NumbersList();

        // "-"붙은 string은 properties에서 뽑아내서 String[] 다른 배열에 넣어주기
        String[] negativeProperties = Arrays.stream(properties)
                .filter(s -> s.startsWith("-"))
                .map(s -> s.substring(1))
                .toArray(String[]::new);

        String[] positiveProperties = Arrays.stream(properties)
                .filter(s -> !s.startsWith("-"))
                .toArray(String[]::new);

        if (numberChecker.isMutuallyExclusive(properties)) {
            return;
        }

        List<Check> negativeChecks = Arrays.stream(negativeProperties)
                .map(numbersList::getCheckable)
                .filter(Objects::nonNull)
                .toList();

        List<Check> positiveChecks = Arrays.stream(positiveProperties)
                .map(numbersList::getCheckable)
                .filter(Objects::nonNull)
                .toList();

        int counter = 0;
        for (long i = start; counter < count; i++) {
            final long number = i;
            if (positiveChecks.stream().allMatch(check -> check.check(number)) &&
                    negativeChecks.stream().noneMatch(check -> check.check(number))) {
                System.out.printf("%,d is %s\n", i, numberChecker.checkResult(i));
                counter++;
            }
        }
    }
}
