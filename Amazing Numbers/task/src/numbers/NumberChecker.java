package numbers;

import numbers.check.Check;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class NumberChecker {

    private List<Check> checkables;

    public NumberChecker(List<Check> checkables) {
        this.checkables = checkables;
    }

    public void checkNumber(long num) {
        for (Check checkable : checkables) {
            System.out.printf("%s: %b\n", checkable.getName(), checkable.check(num));
        }
    }

    public String checkResult(long num) {
        return checkables.stream()
                .filter(checkable -> checkable.check(num))
                .map(Check::getName)
                .collect(Collectors.joining(", "));
    }

    public boolean isMutuallyExclusive(String[] properties) {
        List<List<String>> mutuallyExclusive = List.of(
                List.of("even", "odd"),
                List.of("duck", "spy"),
                List.of("sunny", "square"),
                List.of("happy", "sad"),
                List.of("-even", "-odd"),
                List.of("-duck", "-spy"),
                List.of("-happy", "-sad"),
                List.of("even", "-even"),
                List.of("odd", "-odd"),
                List.of("duck", "-duck"),
                List.of("spy", "-spy"),
                List.of("sunny", "-sunny"),
                List.of("square", "-square"),
                List.of("happy", "-happy"),
                List.of("sad", "-sad"),
                List.of("gapful", "-gapful"),
                List.of("buzz", "-buzz"),
                List.of("palindromic", "-palindromic"),
                List.of("jumping", "-jumping")
        );

        for (List<String> list : mutuallyExclusive) {
            if (new HashSet<>(List.of(properties)).containsAll(list)) {
                System.out.print("The request contains mutually exclusive properties: [");
                System.out.print(String.join(", ", list) + "]\n");
                System.out.println("There are no numbers with these properties.");
                return true;
            }
        }
        return false;
    }
}
