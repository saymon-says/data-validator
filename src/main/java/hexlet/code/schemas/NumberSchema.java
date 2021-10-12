package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    private static final NumberSchema schema = new NumberSchema();

    public NumberSchema required() {
        Predicate<Integer> number = num -> num instanceof Integer;
        predicateList.add(number);
        return schema;
    }

    public NumberSchema positive() {
        Predicate<Integer> notNegative = num -> num > 0;
        predicateList.add(notNegative);
        return schema;
    }

    public NumberSchema range(int start, int end) {
        Predicate<Integer> between = num -> start <= num && num <= end;
        predicateList.add(between);
        return schema;
    }
}
