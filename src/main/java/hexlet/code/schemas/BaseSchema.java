package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    public static List<Predicate> predicateList = new ArrayList<>();

    public boolean isValid(Object obj) {
        if (!predicateList.isEmpty()) {
            for (Predicate predicate : predicateList) {
                if (!predicate.test(obj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
