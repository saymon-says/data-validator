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
        assertThat(schema.isValid(null)).isEqualTo(true);
        assertThat(schema.isValid(THREE)).isEqualTo(true);
    }

    @Test
    public void testRequire() {
        schema.required();
        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid(0)).isEqualTo(true);
        assertThat(schema.isValid(TWO_NEGATIVE)).isEqualTo(true);
    }

    @Test
    public void testPositive() {
        schema.positive();
        assertThat(schema.isValid(1)).isEqualTo(true);
        assertThat(schema.isValid(TWO_NEGATIVE)).isEqualTo(false);
    }

    @Test
    public void testRange() {
        schema.range(TWO, SIX);
        assertThat(schema.isValid(THREE)).isEqualTo(true);
        assertThat(schema.isValid(0)).isEqualTo(false);
        assertThat(schema.isValid(SIX)).isEqualTo(true);
    }

    @Test
    public void testRangePositive() {
        schema.range(TWO_NEGATIVE, SIX).positive();
        assertThat(schema.isValid(0)).isEqualTo(false);
        assertThat(schema.isValid(THREE)).isEqualTo(true);
    }
}
