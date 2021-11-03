package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    private final List<Predicate> predicateList = new ArrayList<>();

    public final boolean isValid(Object obj) {
        if (!predicateList.isEmpty()) {
            for (Predicate predicate : predicateList) {
                if (!predicate.test(obj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final List<Predicate> getPredicateList() {
        return predicateList;
    }
}
