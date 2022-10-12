/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gavinlinnihan
 */
public class Hideout<T> {
 
    private T type;
    
    public Hideout(){
        
    }
    
    public void putIntoHideout(T toHide){
        this.type = toHide;
    }
    
    public T takeFromHideout(){
        if(this.type == null){
            return null;
        }
        T tempType = type;
        type = null;
        return tempType;
    }
    
    public boolean isInHideout() {
        return this.type != null;
    }
}
