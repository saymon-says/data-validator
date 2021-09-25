package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class App {

    public static void main(String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();

        System.out.println(schema.isValid(null));
        schema.required();
        System.out.println(schema.isValid("null"));
        System.out.println(schema.isValid(""));
        System.out.println(schema.contains("hello").isValid("helo my neighbors"));
        System.out.println(schema.minLength(13).isValid("alkskld"));

    }

}
