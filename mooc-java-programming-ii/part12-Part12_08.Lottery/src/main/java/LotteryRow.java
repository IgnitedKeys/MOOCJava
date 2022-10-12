
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;
    Random ladyLuck = new Random();

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        int number = 0;
        for(int i = 0; i < 7; i++){
            do {
                number = ladyLuck.nextInt(40) + 1;
            } while(containsNumber(number));
            
            numbers.add(number);
        }
        // the method containsNumber is probably useful
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        return this.numbers.contains(number);
    }
}

