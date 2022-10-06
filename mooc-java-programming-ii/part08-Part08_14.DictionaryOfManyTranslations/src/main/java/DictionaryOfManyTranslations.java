
import java.util.ArrayList;
import java.util.HashMap;


public class DictionaryOfManyTranslations {

    public static void main(String[] args) {
        // Testaa sanakirjaa täällä
        DictionaryOfManyTranslations dictionary = new DictionaryOfManyTranslations();
        dictionary.add("lie", "maata");
        dictionary.add("lie", "valehdella");

        dictionary.add("bow", "jousi");
        dictionary.add("bow", "kumartaa");

        System.out.println(dictionary.translate("lie"));
        dictionary.remove("bow");
        System.out.println(dictionary.translate("bow"));
    }
    
    HashMap<String, ArrayList<String>> translations;
    
    public DictionaryOfManyTranslations() {
        this.translations = new HashMap<>();
    }
    
    public void add(String word, String translation) {
        translations.putIfAbsent(word, new ArrayList<>());
        
        ArrayList<String> value = translations.get(word);
        value.add(translation);
    }
    
    public ArrayList<String> translate(String word) {
        if(!translations.containsKey(word)) {
            return new ArrayList<>();
        }
        ArrayList<String> value = translations.get(word);
        
        return value;
    }
    
    public void remove(String word) {
        translations.remove(word);
    }
}
