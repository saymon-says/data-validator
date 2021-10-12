package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    private static final StringSchema schema = new StringSchema();

    public StringSchema required() {
        Predicate<String> notEmpty = str -> str != null && !str.isEmpty();
        predicateList.add(notEmpty);
        return schema;
    }

    public StringSchema minLength(int count) {
        Predicate<String> length = str -> str.length() >= count;
        predicateList.add(length);
        return schema;
    }


    public StringSchema contains(String str) {
        Predicate<String> contain = s -> s.contains(str);
        predicateList.add(contain);
        return schema;
    }
}
