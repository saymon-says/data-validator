package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        Predicate<Object> hash = map -> map instanceof Map;
        getPredicateList().add(hash);
        return this;
    }

    public final MapSchema sizeof(int sizeMap) {
        Predicate<Object> size = map -> {
            if (map instanceof Map) {
                return sizeMap == ((Map<?, ?>) map).size();
            }
            return false;
        };
        getPredicateList().add(size);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> mapMode) {
        Predicate<Object> mode = map -> {
            boolean isValid = true;
            if (map instanceof Map) {
                for (Map.Entry<String, BaseSchema> schemaEntry : mapMode.entrySet()) {
                    String fieldName = schemaEntry.getKey();
                    BaseSchema validator = schemaEntry.getValue();
                    isValid = isValid && validator.isValid(((Map<?, ?>) map).get(fieldName));
                }
                return isValid;
            }
            return false;
        };

        getPredicateList().add(mode);
        return this;
    }
}
