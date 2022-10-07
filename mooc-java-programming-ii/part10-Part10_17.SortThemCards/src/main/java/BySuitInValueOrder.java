
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author alinnihan
 */
public class BySuitInValueOrder implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        int compare = c1.getSuit().ordinal() - c2.getSuit().ordinal();

        if (compare == 0) {
            return c1.getValue() - c2.getValue();
        }

        return compare;
    }
}
