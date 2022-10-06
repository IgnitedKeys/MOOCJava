
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("f.e", "for example");
        hashmap.put("etc.", "and so on");
        hashmap.put("i.e", "more precisely");

        printKeys(hashmap);
        System.out.println("---");
        printKeysWhere(hashmap, "i");
        System.out.println("---");
        printValuesOfKeysWhere(hashmap, ".e");
    }

    public static void printKeys(HashMap<String, String> hashmap) {
        Set<String> keys = hashmap.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }

    public static void printKeysWhere(HashMap<String, String> hashmap, String text) {

        for (String key : hashmap.keySet()) {
            if (!key.contains(text)) {
                continue;
            }
            System.out.println(key);
        }

    }

    public static void printValuesOfKeysWhere(HashMap<String, String> hashmap, String text) {
        for (String key : hashmap.keySet()) {
            if (!key.contains(text)) {
                continue;
            }
            System.out.println(hashmap.get(key));
        }

    }

}
