import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String name1 = scanner.nextLine();
        name = name.replace(" ", "");
        name1 = name1.replace(" ", "");

        if (name.equals(name1)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }

    }
}