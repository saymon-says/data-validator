package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> shemas = new HashMap<>();
        shemas.put("name", v.string().required());
        shemas.put("age", v.number().positive());
        schema.shape(shemas);
    }

}
