package hexlet.code.schemas;

import lombok.Data;

@Data
public class StringSchema {

    private static String state = "";
    private static Object object;
    private static StringSchema schema;

    public static boolean isValid(Object obj) {
        if ("".equals(state)) {
            return true;
        } else if ("notNull".equals(state)) {
            return (obj != null) && (!obj.equals(""));
        } else if ("minLength".equals(state)) {
            return obj.toString().length() >= (Integer) object;
        }
        return obj.toString().contains((CharSequence) object);
    }

    public static void required() {
        state = "notNull";
    }

    public static StringSchema minLength(int count) {
        state = "minLength";
        object = count;
        return schema;
    }

    public static StringSchema contains(String str) {
        state = "contains";
        object = str;
        return schema;
    }
}
