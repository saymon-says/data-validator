package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTest {

    private MapSchema schema;
    private Validator v;
    private static final int THREE_NEGATIVE = -3;

    @BeforeEach
    public final void init() {
        v = new Validator();
        schema = v.map();
    }

    @Test
    public void test() {
        assertThat(schema.isValid(null)).isTrue();
    }

    @Test
    public void testRequired() {
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();
        Map<String, String> example = new HashMap<>();
        example.put("key", "value");
        assertThat(schema.isValid(example)).isTrue();
    }

    @Test
    public void testSizeOf() {
        Map<String, String> example = new HashMap<>();
        example.put("key", "value");
        example.put("key1", "value1");
        schema.sizeof(2);
        assertThat(schema.isValid(example)).isTrue();
        assertThat(schema.isValid(new HashMap<>())).isFalse();
    }

    @Test
    public void testShape() {
        Map<String, BaseSchema> shemas = new HashMap<>();
        shemas.put("name", v.string().required());
        shemas.put("age", v.number().positive());
        schema.shape(shemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", THREE_NEGATIVE);

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);

        assertThat(schema.isValid(human1)).isFalse();
        assertThat(schema.isValid(human2)).isTrue();
        assertThat(schema.isValid(human3)).isFalse();
    }

}
