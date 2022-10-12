
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Random ladyLuck = new Random();
        
        System.out.println("How many random numbers should be printed?");
        int inputNumber = Integer.parseInt(scanner.nextLine());
        
        for(int i = 0; i < inputNumber; i++){
            int randomNumber = ladyLuck.nextInt(10);
            System.out.println(randomNumber);
        }
        
    }

}
