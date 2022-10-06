
import java.util.Scanner;



public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        Checker checker = new Checker();
        //boolean form = checker.isDayOfWeek(input);
        //boolean form = checker.allVowels(input);
        boolean form = checker.timeOfDay(input);
        if(form){
            System.out.println("The form is correct");
        } else {
            System.out.println("The form is incorrect");
        }
    }
}
