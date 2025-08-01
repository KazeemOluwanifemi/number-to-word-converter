import java.util.*;

public class Main {
    public static void main(String[] args) {
//        A program to convert each number inputted to a word
//        Take user and validate user input
        while(true){
            Scanner reader = new Scanner(System.in);

            System.out.println("Welcome, what number would you like to convert? ");
            int number;

            if(reader.hasNextInt()){
                number = reader.nextInt();
                System.out.println(convertToWords(number));
                break;
            } else{
                System.out.println("Invalid input, enter a number. ");
            }
        }
    }

// method to convert each group of threes to words and add to the next group of threes of the number input
    public static String convertToWords(int n){
//        handle for keyword "0"
        if(n == 0){
            return "Zero";
        }
//        handle place value for each group of three
        String[] units = {
                " ","One","Two", "Three",
                "Four",    "Five",      "Six",      "Seven",
                "Eight",   "Nine",      "Ten",      "Eleven",
                "Twelve",  "Thirteen",  "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        String[] tens = {
                "",     "",     "Twenty",  "Thirty", "Forty",
                "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        String[] multiplier =
                {"", "Thousand", "Million", "Billion"};

//        res => result
        String res = "";
//        Group determines how many iterations the entire number has to go through
        int group = 0;

//        Process number in group of 1000s
        while (n > 0) {
            if (n % 1000 != 0) {

                int value = n % 1000;
                String temp = "";

                if (value >= 100) {
                    temp = units[value / 100] + " Hundred ";
                    value %= 100;
                }

                if (value >= 20) {
                    temp += tens[value / 10] + " ";
                    value %= 10;
                }


                if (value > 0) {
                    temp += units[value] + " ";
                }

                temp += multiplier[group] + " ";

                res = temp + res;
            }
            n /= 1000;
            group++;
        }

        return res.trim();
    }
}