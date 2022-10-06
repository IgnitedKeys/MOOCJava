
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gavinlinnihan
 */
public class Abbreviations {
    
    private HashMap<String, String> map;
    
    public Abbreviations() {
        this.map = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        map.put(abbreviation, explanation);
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        return map.containsKey(abbreviation);
    }
    
    public String findExplanationFor(String abbreviation){
        if(!map.containsKey(abbreviation)) {
            return null;
        } else {
            return map.get(abbreviation);
        }
    }
    
}
