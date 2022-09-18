import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        String stringForParse = scanner.next();
        //"//[*][%]\n33%,6***3%18099\n-2"
        StringCalculator stringCalculator = new StringCalculator();

        System.out.println(stringCalculator.add(stringForParse));
    }
}