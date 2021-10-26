package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    private static final MapSchema SCHEMA = new MapSchema();

    public final MapSchema required() {
        Predicate<Map> hash = map -> map instanceof Map;
        getPredicateList().add(hash);
        return SCHEMA;
    }

    public final MapSchema sizeOf(int sizeMap) {
        Predicate<Map> size = map -> sizeMap == map.size();
        getPredicateList().add(size);
        return SCHEMA;
    }

    public final MapSchema shape(Map<String, BaseSchema> mapMode) {
        Predicate<Map> mode = map -> {

            return true;
        };

        getPredicateList().add(mode);
        return SCHEMA;
    }
}
