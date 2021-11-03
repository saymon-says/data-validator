package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTest {

    private static final int THREE = 3;
    private StringSchema schema;

    @BeforeEach
    public final void init() {
        Validator v = new Validator();
        schema = v.string();
    }

    @Test
    public void test() {
        assertThat(schema.isValid(null)).isEqualTo(true);
        assertThat(schema.isValid("null")).isEqualTo(true);
    }

    @Test
    public void testRequired() {
        schema.required();
        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid("")).isEqualTo(false);
        assertThat(schema.isValid("null")).isEqualTo(true);
    }

    @Test
    public void testMinLength() {
        schema.minLength(THREE);
        assertThat(schema.isValid("Three")).isEqualTo(true);
        assertThat(schema.isValid("T")).isEqualTo(false);
    }

    @Test
    public void testContains() {
        schema.contains("hello");
        assertThat(schema.isValid("Hello my neighbors!")).isEqualTo(false);
        assertThat(schema.isValid("Hello, hello my neighbors!")).isEqualTo(true);
    }

    @Test
    public void testMinlengthContains() {
        schema.minLength(THREE).contains("hello");
        assertThat(schema.isValid("he")).isEqualTo(false);
        assertThat(schema.isValid("hello!")).isEqualTo(true);
    }
}
