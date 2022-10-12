/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gavinlinnihan
 */
public class List<Type> {
    
    private Type[] values;
    private int firstFreeIndex;
    
    public List(){
        //this is how java allows generic arrays
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }
    
    public void add(Type value){
        //increase array size if array is full
        if(this.firstFreeIndex == this.values.length){
            grow();
        }
        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }
    
    public boolean contains(Type value){
        return indexOfValue(value) >=0;
//        for(int i = 0; i < this.firstFreeIndex; i++){
//            if(this.values[i].equals(value)){
//                return true;
//            }
//        }
//        return false;
    }
    
    public void remove(Type value){
        int indexOfValue = indexOfValue(value);
        if(indexOfValue < 0){
            return; //not found
        }
        moveToTheLeft(indexOfValue);
        this.firstFreeIndex--;
    }
    
    public Type value(int index){
        if(index < 0 || index >= this.firstFreeIndex){
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFreeIndex + "]");
        }
        return this.values[index];
    }
    
    public int size() {
        return this.firstFreeIndex;
    }
    
    
    private void grow(){
        //new array size is 1.5x's bigger
        int newSize = this.values.length + this.values.length / 2;
        Type[] newValues = (Type[]) new Object[newSize];
        
        //copy array values into new array
        for(int i = 0; i <this.values.length; i++){
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }
    
    //public for user
    public int indexOfValue(Type value){
        for(int i = 0; i < this.firstFreeIndex; i ++){
            if(this.values[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
   
    private void moveToTheLeft(int fromIndex){
        for(int i = fromIndex; i < this.firstFreeIndex - 1; i++){
            this.values[i] = this.values[i + 1];
        }
    }
    
}
