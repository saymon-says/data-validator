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
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("null")).isTrue();
    }

    @Test
    public void testRequired() {
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid("null")).isTrue();
    }

    @Test
    public void testMinLength() {
        schema.minLength(THREE);
        assertThat(schema.isValid("Three")).isTrue();
        assertThat(schema.isValid("T")).isFalse();
    }

    @Test
    public void testContains() {
        schema.contains("hello");
        assertThat(schema.isValid("Hello my neighbors!")).isFalse();
        assertThat(schema.isValid("Hello, hello my neighbors!")).isTrue();
    }

    @Test
    public void testMinlengthContains() {
        schema.minLength(THREE).contains("hello");
        assertThat(schema.isValid("he")).isFalse();
        assertThat(schema.isValid("hello!")).isTrue();
    }
}
