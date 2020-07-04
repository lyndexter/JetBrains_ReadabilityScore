import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();


        double perimeterToHalf = (a + b + c) / 2;
        double area = Math.sqrt(perimeterToHalf * (perimeterToHalf - a) * 
                        (perimeterToHalf - b) * (perimeterToHalf - c));

        System.out.print(area);
    }
}
