package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputInt = new Scanner(System.in);
        int choice;
        Square square = new Square();
        ArrayList<Square> list= new ArrayList<>();
        while (true) {
            choice = 0;
            System.out.println("Хотети ввести стороны квадратов?");
            System.out.println("1(да)           2(нет)");
            System.out.println("Выбор: ");
            choice = protectInput();
            if (choice == 1) {

                System.out.print("Введите сторону(0<= чтобы остановить):\n ");

                while (true){
                    System.out.print("Ввод: ");
                    Square square1 = new Square(inputInt.nextInt());
                    if(square1.getLength()<=0)break;
                    else{
                        list.add(square1);
                    }
                }
                System.out.println("Вывести: ");
                System.out.println("1)Площадь: ");
                System.out.println("2)Периметр: ");
                System.out.println("Выбор: ");
                choice = inputInt.nextInt();
                switch (choice) {
                    case 1:
                        for(Square i: list)
                        System.out.println("Площадь квадрата со стороной " + i.getLength() + " равен: " + i.Square(i.getLength()) + "\n");
                        break;
                    case 2:
                        for(Square i: list)
                            System.out.println("Периметр квадрата со стороной " + i.getLength() + " равен: " + i.Perimeter(i.getLength()) + "\n");
                        break;
                    default:
                        System.out.println("Некорректный ввод!" + "\n");
                }

            } else if (choice == 2) break;
            else {
                System.out.println("Некорректный ввод!" + "\n");
                continue;
            }
        }
    }
    public static int protectInput() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Некорректный ввод!");
                System.out.println("Попробуйте ещё раз");
                scanner.next();
                continue;
            }
        }
    }
}


