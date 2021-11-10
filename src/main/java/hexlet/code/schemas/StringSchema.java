package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        Predicate<Object> notEmpty = str -> str instanceof String && !((String) str).isEmpty();
        getPredicateList(notEmpty);
        return this;
    }

    public final StringSchema minLength(int count) {
        Predicate<Object> length = str -> str instanceof String && ((String) str).length() >= count;
        getPredicateList(length);
        return this;
    }

    public final StringSchema contains(String s) {
        Predicate<Object> contain = str -> str instanceof String && ((String) str).contains(s);
        getPredicateList(contain);
        return this;
    }
}
