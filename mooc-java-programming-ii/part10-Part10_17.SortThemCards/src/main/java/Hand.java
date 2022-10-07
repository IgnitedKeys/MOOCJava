
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author alinnihan
 */
public class Hand implements Comparable<Hand>{
    
    private List<Card> hand;
    
    public Hand() {
        this.hand = new ArrayList<>();
    }
    
    public void add(Card card) {
        hand.add(card);
    }
    
    public void print() {
        hand.forEach(card -> System.out.println(card.toString()));
    }
    
    public void sort() {
        Collections.sort(hand);
    }

    @Override
    public int compareTo(Hand hand) {
        return this.sum() - hand.sum();
    }
    
    public void sortBySuit() {
        Collections.sort(hand, new BySuitInValueOrder());
    }
    
    public int sum(){
        return hand.stream().mapToInt(card -> card.getValue()).sum();
        
    }
}
