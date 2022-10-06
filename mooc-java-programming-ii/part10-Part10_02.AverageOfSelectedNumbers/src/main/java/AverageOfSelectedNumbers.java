
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //collection for the stream
        List<String> inputs = new ArrayList<>();
        
        while(true) {
            
            String row = scanner.nextLine();
            if(row.equals("end")) {
                break;
            }
            inputs.add(row);
        }
        
        double positiveAverage = inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(number -> number > 0).average().getAsDouble();
        double negativeAverage = inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(number -> number < 0).average().getAsDouble();
        
        String posOrNeg = scanner.nextLine();
        if(posOrNeg.equals("p")){
            System.out.println(positiveAverage);
        } else if (posOrNeg.equals("n")){
            System.out.println(negativeAverage);
        }
    }
}
