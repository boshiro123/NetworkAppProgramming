import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        while (true) {
            System.out.print("Enter matrix size (n): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Size has to be positive");
                }
            } else {
                System.out.println("Incorrect input, try again");
                scanner.next();
            }
        }

        int[][] matrix = new int[n][n];

        System.out.println("Enter element:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while (true) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    if (scanner.hasNextInt()) {
                        matrix[i][j] = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Incorrect input, element has to be int");
                        scanner.next();
                    }
                }
            }
        }

        int mainDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            mainDiagonalSum += matrix[i][i];
        }
        double mainDiagonalAvg = (double) mainDiagonalSum / n;

        int sideDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            sideDiagonalSum += matrix[i][n - 1 - i];
        }
        double sideDiagonalAvg = (double) sideDiagonalSum / n;

        System.out.println("The average value of the elements on the main diagonal: " + mainDiagonalAvg);
        System.out.println("The average value of the elements on the side diagonal:" + sideDiagonalAvg);

        double ratio = mainDiagonalAvg / sideDiagonalAvg;
        System.out.println("The ratio of averages:" + ratio);

        scanner.close();
    }
}

