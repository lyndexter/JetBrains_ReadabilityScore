import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (name.contains("burg") && name.endsWith("burg")) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}
