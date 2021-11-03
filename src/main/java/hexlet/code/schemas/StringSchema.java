package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        Predicate<Object> notEmpty = str -> {
            if (str instanceof String) {
                return !((String) str).isEmpty();
            }
            return false;
        };
        getPredicateList().add(notEmpty);
        return this;
    }

    public final StringSchema minLength(int count) {
        Predicate<Object> length = str -> {
            if (str instanceof String) {
                return ((String) str).length() >= count;
            }
            return false;
        };
        getPredicateList().add(length);
        return this;
    }

    public final StringSchema contains(String str) {
        Predicate<Object> contain = s -> {
            if (s instanceof String) {
                return ((String) s).contains(str);
            }
            return false;
        };
        getPredicateList().add(contain);
        return this;
    }
}
