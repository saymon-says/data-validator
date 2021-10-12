package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTest {

    private StringSchema schema;

    @BeforeEach
    public void init() {
        Validator v = new Validator();
        schema = v.string();
    }

    @AfterEach
    public void clear() {
        BaseSchema.predicateList = new ArrayList<>();
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
        schema.minLength(3);
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
        schema.minLength(6).contains("hello");
        assertThat(schema.isValid("hello")).isEqualTo(false);
        assertThat(schema.isValid("hello!")).isEqualTo(true);
    }
}
