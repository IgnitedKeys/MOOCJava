/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticTacToe;

/**
 *
 * @author gavinlinnihan
 */
public class Turn {
    
   private String turnIcon;
   private int counter;
   
   public Turn(){
       this.turnIcon = "X";
   }
   
   public String getTurn(){
       return turnIcon;
   }
   
   public void nextTurn(){
       if(this.turnIcon.equals("X")){
           turnIcon = "O";
           
       } else {
           turnIcon = "X";
       }
   }
    
}
