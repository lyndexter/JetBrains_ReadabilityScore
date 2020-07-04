import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String house = scanner.next();
        switch (house) {
            case "triangle":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double perimeterHalf = (a + b + c) / 2;
                double area = Math.sqrt(perimeterHalf * (perimeterHalf - a) *
                        (perimeterHalf - b) * (perimeterHalf - c));
                System.out.println(area);
                break;
            case "rectangle":
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                System.out.println(length * width);
                break;
            case "circle":
                double radis = scanner.nextDouble();
                System.out.println(3.14 * radis * radis);
                break;
            default:
                System.out.println("not a valid house");
                break;
        }
    }
}