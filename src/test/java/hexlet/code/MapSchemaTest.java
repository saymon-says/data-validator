package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTest {

    private MapSchema schema;

    @BeforeEach
    public void init() {
        Validator v = new Validator();
        schema = v.map();
    }

    @AfterEach
    public void clear() {
        BaseSchema.predicateList = new ArrayList<>();
    }

    @Test
    public void test() {
        assertThat(schema.isValid(null)).isEqualTo(true);
    }

    @Test
    public void testRequired() {
        schema.required();
        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid(new HashMap<>())).isEqualTo(true);
        Map<String, String> example = new HashMap<>();
        example.put("key", "value");
        assertThat(schema.isValid(example)).isEqualTo(true);
    }

    @Test
    public void testSizeOf() {
        Map<String, String> example = new HashMap<>();
        example.put("key", "value");
        example.put("key1", "value1");
        schema.sizeOf(2);
        assertThat(schema.isValid(example)).isEqualTo(true);
        assertThat(schema.isValid(new HashMap<>())).isEqualTo(false);
    }

}
