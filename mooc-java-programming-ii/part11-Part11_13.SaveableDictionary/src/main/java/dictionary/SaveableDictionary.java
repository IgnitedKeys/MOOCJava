/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alinnihan
 */
public class SaveableDictionary {

    private Map<String, String> dictionary;
    private Map<String, String> dictionary2;
    private String file;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
        this.dictionary2 = new HashMap<>();
        this.file = null;
    }

    public SaveableDictionary(String file){
        this.dictionary = new HashMap<>();
        this.dictionary2 = new HashMap<>();
        this.file = file;
    }
    
    public void add(String word, String translation) {
        this.dictionary.putIfAbsent(word, translation);
        this.dictionary2.putIfAbsent(translation, word);
    }

    public String translate(String word) {
        String translation = this.dictionary.getOrDefault(word, null);
        if (translation == null) {
            translation = this.dictionary2.getOrDefault(word, null);
        }

        return translation;

    }
    
    public void delete(String word) {
       if(this.dictionary.containsKey(word)){
           String val = this.dictionary.get(word);
           this.dictionary2.remove(val);
           this.dictionary.remove(word);
       }
       
       if(this.dictionary2.containsKey(word)){
           String val = this.dictionary2.get(word);
           this.dictionary.remove(val);
           this.dictionary2.remove(word);
       }
    }
    
    public boolean load() {
        
        List<String> rows = new ArrayList<>();
        
        try {
            Files.lines(Paths.get(this.file))
                    .forEach(row -> rows.add(row));
            
            for(String line : rows) {
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: file not found" + e.getMessage());
            return false;
        }
    }
    
    public boolean save() {
        
        try {
            //use PrintWriter to completely rewrite file-not appending to
            PrintWriter writer = new PrintWriter(this.file);
            //only writing one dictionary to file-not both
            for(String key : this.dictionary.keySet()){
                writer.println(key + ":" + this.dictionary.get(key));
            }
            //close the writer!!
            writer.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found" + ex.getMessage());
            return false;
        }
    }
}
