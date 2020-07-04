import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] words = text.split(" ");
        int maxLength = 0;
        String longestWord = "";

        for (String iterator : words) {
            if (iterator.length() > maxLength) {
                maxLength = iterator.length();
                longestWord = iterator;
            }
        }

        System.out.print(longestWord);

    }
}