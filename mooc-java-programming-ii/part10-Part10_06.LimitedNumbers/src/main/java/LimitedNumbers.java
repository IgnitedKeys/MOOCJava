
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        
        while(true) {
            String input = scanner.nextLine();
            if(Integer.valueOf(input) < 0) {
                break;
            }
            inputs.add(input);
        }
        
        inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(i -> (i > 0) && (i <= 5)).forEach(i -> System.out.println(i));
    }
}
