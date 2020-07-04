import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        int allElements = text.length();
        int counter = 0;

        for (int i = 0; i < allElements; i++) {
            if (text.charAt(i) == 'g' || text.charAt(i) == 'G' ||
                    text.charAt(i) == 'C' || text.charAt(i) == 'c') {
                counter++;
            }


        }

        System.out.print((double) counter * 100 / allElements);
    }
}