package hexlet.code;

import hexlet.code.schemas.StringSchema;
import lombok.Data;

@Data
public class Validator {

    public static StringSchema string() {
        return new StringSchema();
    }
}
