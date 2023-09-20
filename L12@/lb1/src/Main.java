import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inputString = new Scanner(System.in);
        System.out.print("Введите имя пользователя: ");
        String name = inputString.nextLine();
        ArrayList<Double> array = new ArrayList<>();
        System.out.println(array.size());



      Culculate culculate = new Culculate();
        System.out.println("Объем Земли в кубических милях и кубических километрах: " + culculate.V(culculate.getEarthDiameter()) +" км^3\n");
        System.out.println("Объем Солнца в кубических милях и кубических километрах: "+culculate.V(culculate.getSunDiameter())+" км^3\n");
        System.out.println("Отношение объема Солнца к объему Земли:" + culculate.V(culculate.getSunDiameter())/culculate.V(culculate.getEarthDiameter())+" км^3\n");
    }
}