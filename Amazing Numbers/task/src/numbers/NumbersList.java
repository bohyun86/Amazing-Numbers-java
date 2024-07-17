package numbers;

import numbers.check.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NumbersList {
    List<Check> checkableList = new ArrayList<>();

    public NumbersList() {
        checkableList.add(new Buzz());
        checkableList.add(new Duck());
        checkableList.add(new Palindromic());
        checkableList.add(new Gapful());
        checkableList.add(new Spy());
        checkableList.add(new Square());
        checkableList.add(new Sunny());
        checkableList.add(new Jumping());
        checkableList.add(new Even());
        checkableList.add(new Odd());
        checkableList.add(new Happy());
        checkableList.add(new Sad());
    }

    public List<Check> getCheckableList() {
        return checkableList;
    }

    public Check getCheckable(String checkableName) {
        for (Check check : checkableList) {
            if (check.getName().equals(checkableName)) {
                return check;
            }
        }
        return null;
    }

    public void removeCheckable(String checkableName) {
        Iterator<Check> iterator = checkableList.iterator();
        if (iterator.hasNext()) {
            Check check = iterator.next();
            if (check.getName().equals(checkableName)) {
                iterator.remove();
            }
        }
    }




}
