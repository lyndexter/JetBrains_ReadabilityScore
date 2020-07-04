import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vectorAonX = scanner.nextDouble();
        double vectorAonY = scanner.nextDouble();
        double vectorBonX = scanner.nextDouble();
        double vectorBonY = scanner.nextDouble();

        double angle = Math.acos((vectorAonX * vectorBonX + vectorAonY * vectorBonY) /
                (Math.hypot(vectorAonX, vectorAonY) * Math.hypot(vectorBonY, vectorBonX)));
        System.out.print(Math.toDegrees(angle));


    }
}