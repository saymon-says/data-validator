package hexlet.code.schemas;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    private static final MapSchema schema = new MapSchema();

    public MapSchema required() {
        Predicate<Map> hash = map -> map instanceof Map;
        predicateList.add(hash);
        return schema;
    }

    public MapSchema sizeOf(int sizeMap) {
        Predicate<Map> size = map -> sizeMap == map.size();
        predicateList.add(size);
        return schema;
    }

    public MapSchema shape(Map<String, BaseSchema> mapMode) {
        Predicate<Map> mode = map -> {

            return true;
        };

        predicateList.add(mode);
        return schema;
    }
}
