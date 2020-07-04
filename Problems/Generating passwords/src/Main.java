import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int numberA = scanner.nextInt();
        int numberB = scanner.nextInt();
        int numberC = scanner.nextInt();
        int numberN = scanner.nextInt();

        numberN -= numberC + numberA + numberB;

        StringBuilder password = new StringBuilder("/");
        for (int i = 0; i < numberA; i++) {
            char symbol = (char) (random.nextInt(26) + 'A');
            if (password.charAt(password.length() - 1) == symbol) {
                numberA++;
            } else {
                password.append(symbol);
            }
        }
        for (int i = 0; i < numberB; i++) {
            char symbol = (char) (random.nextInt(26) + 'a');
            if (password.charAt(password.length() - 1) == symbol) {
                numberB++;
            } else {
                password.append(symbol);
            }
        }
        for (int i = 0; i < numberC; i++) {
            char symbol = (char) (random.nextInt(9) + '0');
            if (password.charAt(password.length() - 1) == symbol) {
                numberC++;
            } else {
                password.append(symbol);
            }
        }
        for (int i = 0; i < numberN; i++) {
            char symbol = (char) (random.nextInt(26) + 'A');
            if (password.charAt(password.length() - 1) == symbol) {
                numberN++;
            } else {
                password.append(symbol);
            }
        }

        password = new StringBuilder(password.toString().replace("/", ""));
        System.out.print(password);

    }
}