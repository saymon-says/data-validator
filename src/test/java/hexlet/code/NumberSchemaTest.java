package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSchemaTest {

    private NumberSchema schema;
    private static final int THREE = 3;
    private static final int TWO_NEGATIVE = -2;
    private static final int TWO = 2;
    private static final int SIX = 6;

    @BeforeEach
    public final void init() {
        Validator v = new Validator();
        schema = v.number();
    }

    @Test
    public void test() {
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(THREE)).isTrue();
    }

    @Test
    public void testRequire() {
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(0)).isTrue();
        assertThat(schema.isValid(TWO_NEGATIVE)).isTrue();
    }

    @Test
    public void testPositive() {
        schema.positive();
        assertThat(schema.isValid(1)).isTrue();
        assertThat(schema.isValid(TWO_NEGATIVE)).isFalse();
    }

    @Test
    public void testRange() {
        schema.range(TWO, SIX);
        assertThat(schema.isValid(THREE)).isTrue();
        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(SIX)).isTrue();
    }

    @Test
    public void testRangePositive() {
        schema.range(TWO_NEGATIVE, SIX).positive();
        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(THREE)).isTrue();
    }
}
