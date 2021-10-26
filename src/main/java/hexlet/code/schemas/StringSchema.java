package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    private static final StringSchema SCHEMA = new StringSchema();

    public final StringSchema required() {
        Predicate<String> notEmpty = str -> str != null && !str.isEmpty();
        getPredicateList().add(notEmpty);
        return SCHEMA;
    }

    public final StringSchema minLength(int count) {
        Predicate<String> length = str -> str.length() >= count;
        getPredicateList().add(length);
        return SCHEMA;
    }


    public final StringSchema contains(String str) {
        Predicate<String> contain = s -> s.contains(str);
        getPredicateList().add(contain);
        return SCHEMA;
    }
}
