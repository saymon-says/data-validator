package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        Predicate<Object> number = num -> num instanceof Integer;
        getPredicateList(number);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Object> notNegative = num -> num == null || num instanceof Integer && (Integer) num > 0;
        getPredicateList(notNegative);
        return this;
    }

    public final NumberSchema range(int start, int end) {
        Predicate<Object> between = num -> num instanceof Integer && start <= (Integer) num && (Integer) num <= end;
        getPredicateList(between);
        return this;
    }
}
