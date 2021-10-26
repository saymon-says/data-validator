package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> shemas = new HashMap<>();
        shemas.put("name", v.string().required());
        schema.shape(shemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        schema.isValid(human1);
    }

}
