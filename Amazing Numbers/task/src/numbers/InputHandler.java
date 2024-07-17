package numbers;

import numbers.check.Check;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputHandler {

    public String[] getInputs() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a request: ");
        String[] input = scanner.nextLine().split(" ");
        int length = input.length;
        if (length == 1) {
            if (isNaturalNum(input[0], "first")) {
                return input;
            }
        } else if (length == 2) {
            if (isNaturalNum(input[0], "first") && isNaturalNum(input[1], "second")) {
                return input;
            }
        } else {
            String[] conditions = Arrays.copyOfRange(input, 2, input.length);
            if (isContained(conditions)) {
                return input;
            }
        }
        return getInputs();
    }

    private boolean isNaturalNum(String num, String comment) {
        if (!num.matches("\\d+") || Long.parseLong(num) < 0) {
            System.out.printf("The %s parameter should be a natural number or zero.\n", comment);
            return false;
        }
        return true;
    }

    private boolean isContained(String[] num) {
        List<Check> checkables = new NumbersList().getCheckableList();
        List<String> result = new ArrayList<>();
        for (String s : num) {
            if (s.startsWith("-")) {
                s = s.substring(1);
            }
            if (checkables.stream().map(Check::getName).noneMatch(s::equalsIgnoreCase)) {
                result.add(s);
            }
        }
        if (result.isEmpty()) {
            return true;
        } else if (result.size() == 1) {
            System.out.println("The property [" + result.get(0) + "] is wrong.");
            System.out.println("Available properties: " + checkables.stream()
                    .map(Check::getName)
                    .collect(Collectors.joining(", ", "[", "]")));
            return false;
        } else {
            System.out.println("The property " + result.stream().collect(Collectors.joining(",", "[", "]")) + " are wrong.");
            System.out.println("Available properties: " + checkables.stream()
                    .map(Check::getName)
                    .collect(Collectors.joining(", ", "[", "]")));
            return false;
        }
    }
}
