
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gavinlinnihan
 */
public class Pipe <T>{
    private ArrayList<T> stack;
    
    
    public Pipe(){
        this.stack = new ArrayList<>();
    }
    
    public void putIntoPipe(T value){
        this.stack.add(value);
    }
    
    public T takeFromPipe(){
        if (!this.stack.isEmpty()){
            T temp = this.stack.get(0);
            this.stack.remove(0);
            return temp;
        }
        return null;
    }
    
    public boolean isInPipe(){
        return !this.stack.isEmpty();
    }
}
