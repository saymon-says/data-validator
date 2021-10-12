package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSchemaTest {

    private NumberSchema schema;

    @BeforeEach
    public void init() {
        Validator v = new Validator();
        schema = v.number();
    }

    @AfterEach
    public void clear() {
        BaseSchema.predicateList = new ArrayList<>();
    }

    @Test
    public void test() {
        assertThat(schema.isValid(null)).isEqualTo(true);
        assertThat(schema.isValid(3)).isEqualTo(true);
    }

    @Test
    public void testRequire() {
        schema.required();
        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid(0)).isEqualTo(true);
        assertThat(schema.isValid(-2)).isEqualTo(true);
    }

    @Test
    public void testPositive() {
        schema.positive();
        assertThat(schema.isValid(1)).isEqualTo(true);
        assertThat(schema.isValid(-2)).isEqualTo(false);
    }

    @Test
    public void testRange() {
        schema.range(2,6);
        assertThat(schema.isValid(3)).isEqualTo(true);
        assertThat(schema.isValid(0)).isEqualTo(false);
        assertThat(schema.isValid(6)).isEqualTo(true);
    }

    @Test
    public void testRangePositive() {
        schema.range(-2, 5).positive();
        assertThat(schema.isValid(0)).isEqualTo(false);
        assertThat(schema.isValid(3)).isEqualTo(true);
    }
}
