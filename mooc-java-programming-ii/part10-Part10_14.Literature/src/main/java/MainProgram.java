
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        List<String> bookNames = new ArrayList<>();
//        List<Integer> ages = new ArrayList<>();
        Map<String, Integer> books = new HashMap<>();

        while (true) {
            System.out.println("Input the name of the book, empty stops:");

            String bookName = scanner.nextLine();
            if(bookName.equals("")){
                break;
            }
            //bookNames.add(bookName);
            System.out.println("Input the age recommendation:");
            int ageGroup = Integer.valueOf(scanner.nextLine());
            //ages.add(ageGroup);
            books.put(bookName, ageGroup);
        }

        //long numberOfBooks = bookNames.stream().count();
        long numberOfBooks = books.keySet().stream().count();
        System.out.println(numberOfBooks + " books in total.\n");
        System.out.println("Books:");
        //books.forEach((book, age) -> System.out.println("" + book + "(recommended for " + age + " year-olds or older)"));
    }

}
