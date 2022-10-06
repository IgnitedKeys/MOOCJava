

public class Checker {

    //check if input is abbreviation of weekdays
    public boolean isDayOfWeek(String string) {
        String regex = "(mon|tue|wed|thu|fri|sat|sun)+";
        
        return string.matches(regex);
    }
    
    //check if input is all vowels
    public boolean allVowels(String string) {
        String regex = "(a|e|i|o|u)+";
        return string.matches(regex);
    }
    
    //hh:mm:ss format with 24hr clock (00:00:00 - 23:59:59)
    public boolean timeOfDay(String string){
        //String regex = "(2[0-3]|[01]?[0-9]):([0]?[0-9]|[10-59]):([0]?[0-9]|[10-59])";
        String regex = "(2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])";
        return string.matches(regex);
    }
}
//00 01 02 03 04 05 06 07 08 09 -> 0[0-9]{1}
//10 11 12 13 14 15 16 17 18 19 -> 1[0-9]{1}
//20 21 22 23                   -> 2[0-3]{1}
//:{1}
//00 01 02 03 04 05 06 07 08 09 
//10 ....59