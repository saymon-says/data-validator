package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    private static final NumberSchema SCHEMA = new NumberSchema();

    public final NumberSchema required() {
        Predicate<Integer> number = num -> num instanceof Integer;
        getPredicateList().add(number);
        return SCHEMA;
    }

    public final NumberSchema positive() {
        Predicate<Integer> notNegative = num -> num > 0;
        getPredicateList().add(notNegative);
        return SCHEMA;
    }

    public final NumberSchema range(int start, int end) {
        Predicate<Integer> between = num -> start <= num && num <= end;
        getPredicateList().add(between);
        return SCHEMA;
    }
}
