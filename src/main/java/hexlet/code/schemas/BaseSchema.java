package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    private static final List<Predicate> PREDICATE_LIST = new ArrayList<>();

    public final boolean isValid(Object obj) {
        if (!PREDICATE_LIST.isEmpty()) {
            for (Predicate predicate : PREDICATE_LIST) {
                if (!predicate.test(obj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Predicate> getPredicateList() {
        return PREDICATE_LIST;
    }
}
