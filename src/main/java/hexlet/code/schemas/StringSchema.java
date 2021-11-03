package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        Predicate<String> notEmpty = str -> str != null && !str.isEmpty();
        getPredicateList().add(notEmpty);
        return this;
    }

    public final StringSchema minLength(int count) {
        Predicate<String> length = str -> str.length() >= count;
        getPredicateList().add(length);
        return this;
    }

    public final StringSchema contains(String str) {
        Predicate<String> contain = s -> s.contains(str);
        getPredicateList().add(contain);
        return this;
    }
}
