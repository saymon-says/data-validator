package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        Predicate<Integer> number = num -> num instanceof Integer;
        getPredicateList().add(number);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Integer> notNegative = num -> num == null || num > 0;
        getPredicateList().add(notNegative);
        return this;
    }

    public final NumberSchema range(int start, int end) {
        Predicate<Integer> between = num -> start <= num && num <= end;
        getPredicateList().add(between);
        return this;
    }
}
