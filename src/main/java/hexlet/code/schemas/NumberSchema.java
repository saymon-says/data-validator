package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        Predicate<Object> number = num -> num instanceof Integer;
        getPredicateList().add(number);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Object> notNegative = num -> {
            if (num instanceof Integer) {
                return (Integer) num > 0;
            } else if (num == null) {
                return true;
            }
            return false;
        };
        getPredicateList().add(notNegative);
        return this;
    }

    public final NumberSchema range(int start, int end) {
        Predicate<Object> between = num -> {
            if (num instanceof Integer) {
                return start <= (Integer) num && (Integer) num <= end;
            }
            return false;
        };
        getPredicateList().add(between);
        return this;
    }
}
