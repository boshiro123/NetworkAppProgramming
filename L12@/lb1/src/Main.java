import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculate calculate = new Calculate();
        System.out.println("Task: Calculate \n" +
                "– Earth volume in miles^3 and km^3\n" +
                "– Sun volume in miles^3 and km^3\n" +
                "– Ratio Sun and Earth volume.\n");
        while (true) {
            System.out.println("Do you want to calculate or exit?");
            System.out.println("      1(Enter)     2(Exit)");
            switch (input.nextInt()) {
                case 1:
                    task(calculate);
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Invalid input, try again");
                    continue;
            }
        }
    }
    public static void task(Calculate calculate){
        System.out.println("Earth volume:\n- "
                + calculate.Volume(calculate.getEarthDiameterMili()) + " miles^3 \n- " +
                +calculate.Volume(calculate.getEarthDiameter()) + " km^3\n");
        System.out.println("Sun volume:\n- " +
                calculate.Volume(calculate.getSunDiameterMili()) + " miles^3 \n- " +
                +calculate.Volume(calculate.getSunDiameter()) + " km^3\n");
        System.out.println("Ratio Sun and Earth volume:\n- " +
                calculate.Ratio(calculate.getSunDiameterMili(), calculate.getEarthDiameterMili()) + " miles^3 \n- " +
                calculate.Ratio(calculate.getSunDiameter(), calculate.getEarthDiameter()) + " km^3\n");
    }

}