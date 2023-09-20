import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);
        String text = "";
        String word = "";
        System.out.println("Использовать строки по умолчанию или ввести свои?");
        System.out.println("        1(По умолчанию)          2(Ввести)");
        switch (scanner.nextInt()){
            case 1:
                text = "This is a sample text. This text sample contains the word sample' multiple times.";
                word = "sample";
                break;
            case 2:
                System.out.println("Текст: ");
                text=inputStr.nextLine();
                System.out.println("Слово: ");
                word = inputStr.nextLine();
                break;
            default:
                System.out.println("Не корректный выбор");
                System.exit(0);
        }
        new FirstThread("The first", text, word); // создать поток
        new SecondThread("The second", text);
        new ThirdThread("The third", text);
        try {
// ожидать завершения других потоков исполнения
            Thread.sleep(10000);
        } catch (InterruptedException е) {
            System.out.println("Глaвный поток прерван");
        }
        System.out.println("Глaвный поток завершен.");
    }
}

