import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        name = name.replace("a", "b");
        System.out.println(name);
    }

}
