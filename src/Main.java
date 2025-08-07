import java.util.*;

public class Main {
    public static void main(String[] args) {
//        A program to convert each number inputted to a word

//        Take user and validate user input
        while(true){
            Scanner reader = new Scanner(System.in);

            System.out.println("Welcome, what number would you like to convert? ");

            if(reader.hasNextLine()){
                String number = "";
                long numbers = 0;

                number = reader.nextLine();
                if(number.contains(".")){
                    String[] pieces = number.split(".");
                    long whole = Long.parseLong(pieces[0]);
                    long decimal = Long.parseLong(pieces[1]);

                    System.out.println(convertToWords(whole) + " point " + convertToWordsDec(decimal));

                } else {
                    numbers = Long.parseLong(number);
                    System.out.println(convertToWords(numbers));
                }
                break;
            } else{
                System.out.println("Invalid input, enter a number. ");
            }
        }
    }

// method to convert each group of threes to words and add to the next group of threes of the number input
    private static HashMap<Integer, String> getMultiplier() {
    HashMap<Integer,String> multiplier = new HashMap<>();
    multiplier.put(0," ");
    multiplier.put(1,"Thousand");
    multiplier.put(2,"Million");
    multiplier.put(3,"Billion");
    return multiplier;
}
    private static HashMap<Integer, String> getTens() {
        HashMap<Integer,String> tens = new HashMap<>();
        tens.put(2, "Twenty");
        tens.put(3, "Thirty");
        tens.put(4, "Forty");
        tens.put(5, "Fifty");
        tens.put(6, "Sixty");
        tens.put(7, "Seventy");
        tens.put(8, "Eighty");
        tens.put(9, "Ninety");
        return tens;
    }
    private static HashMap<Integer, String> getUnits() {
        HashMap<Integer,String> units = new HashMap<>();
        units.put(1, "One");
        units.put(2, "Two");
        units.put(3, "Three");
        units.put(4, "Four");
        units.put(5, "Five");
        units.put(6, "Six");
        units.put(7, "Seven");
        units.put(8, "Eight");
        units.put(9, "Nine");
        units.put(10, "Ten");
        units.put(11, "Eleven");
        units.put(12, "Twelve");
        units.put(13, "Thirteen");
        units.put(14, "Fourteen");
        units.put(15, "Fifteen");
        units.put(16, "Sixteen");
        units.put(17, "Seventeen");
        units.put(18, "Eighteen");
        units.put(19, "Nineteen");
        return units;
    }

    public static String convertToWords(long n){
//        handle for keyword "0"
        if(n == 0){
            return "Zero";
        }

        HashMap<Integer, String> units = getUnits();

        HashMap<Integer, String> tens = getTens();

        HashMap<Integer, String> multiplier = getMultiplier();

//        res => result
        String res = "";
//        Group determines how many iterations the entire number has to go through
        int group = 0;

//        Process number in group of 1000s
        while (n > 0) {
            if (n % 1000 != 0) {

                long value = n % 1000;
                String temp = "";


                if (value >= 100) {
                    Integer key = Math.toIntExact(value / 100);
                    String keyValue = units.get(key);
                    temp = keyValue + " Hundred ";
                    value %= 100;
                }

                if (value >= 20) {
                    Integer key = Math.toIntExact(value / 10);
                    String keyValue = tens.get(key);
                    temp += keyValue + " ";
                    value %= 10;
                }


                if (value > 0) {
                    Integer key = Math.toIntExact(value);
                    String keyValue = units.get(key);
                    temp += keyValue + " ";
                }

                Integer key = group;
                String keyValue = multiplier.get(key);
                temp += keyValue + " ";

                res = temp + res;
            }
            n /= 1000;
            group++;
        }

        return res.trim();
    }

    public static String convertToWordsDec(long n){
//        handle for keyword zero, zeros are typically ignored in decimal parts of a number
//        Tenths place (1/10)
        HashMap<Integer, String> tenths = new HashMap<>();
        tenths.put(1, "One tenth");
        tenths.put(2, "Two tenths");
        tenths.put(3, "Three tenths");
        tenths.put(4, "Four tenths");
        tenths.put(5, "Five tenths");
        tenths.put(6, "Six tenths");
        tenths.put(7, "Seven tenths");
        tenths.put(8, "Eight tenths");
        tenths.put(9, "Nine tenths");

//         Hundredths place (1/100)
        HashMap<Integer, String> hundredths = new HashMap<>();
        hundredths.put(1, "One hundredth");
        hundredths.put(2, "Two hundredths");
        hundredths.put(3, "Three hundredths");
        hundredths.put(4, "Four hundredths");
        hundredths.put(5, "Five hundredths");
        hundredths.put(6, "Six hundredths");
        hundredths.put(7, "Seven hundredths");
        hundredths.put(8, "Eight hundredths");
        hundredths.put(9, "Nine hundredths");

//         Thousandths place (1/1000)
        HashMap<Integer, String> thousandths = new HashMap<>();
        thousandths.put(1, "One thousandth");
        thousandths.put(2, "Two thousandths");
        thousandths.put(3, "Three thousandths");
        thousandths.put(4, "Four thousandths");
        thousandths.put(5, "Five thousandths");
        thousandths.put(6, "Six thousandths");
        thousandths.put(7, "Seven thousandths");
        thousandths.put(8, "Eight thousandths");
        thousandths.put(9, "Nine thousandths");


        String res = "";
        int group = 0;

        while(n > 0) {
            if(n % 1000 != 0){
                long value = n % 1000;
                String temp = "";

                if(value >= 100){
                    Integer key = Math.toIntExact(value/100);
                    String keyValue = tenths.get(key);
                    temp = keyValue + " H"
                }
            }
        }

    }
}