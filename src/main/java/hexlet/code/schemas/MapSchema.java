package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        Predicate<Map> hash = map -> map instanceof Map;
        getPredicateList().add(hash);
        return this;
    }

    public final MapSchema sizeof(int sizeMap) {
        Predicate<Map> size = map -> sizeMap == map.size();
        getPredicateList().add(size);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> mapMode) {
        Predicate<Map> mode = map -> {
            boolean isValid = true;
            for (Map.Entry<String, BaseSchema> schemaEntry : mapMode.entrySet()) {
                String fieldName = schemaEntry.getKey();
                BaseSchema validator = schemaEntry.getValue();
                isValid = isValid && validator.isValid(map.get(fieldName));
            }
            return isValid;
        };

        getPredicateList().add(mode);
        return this;
    }
}
