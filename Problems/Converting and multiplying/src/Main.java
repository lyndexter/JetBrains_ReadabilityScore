import java.util.Scanner;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String digit = scanner.nextLine();
            if ("0".equals(digit)) {
                return;
            }
            Pattern patternNotDigit = Pattern.compile("[^\\d]");
            if (patternNotDigit.matcher(digit).find()) {
                System.out.println("Invalid user input: " + digit);
            } else {
                int number = Integer.parseInt(digit) * 10;
                System.out.println(number);
            }


        }
    }
}
