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
        final String text1 = text;
        final String word1 =  word;
        Tasks task1 = new Tasks();
        Runnable runnable1 = ()->{
            task1.method1(text1, word1,"Thread 1");
        };
        Runnable runnable2 = ()->{
            task1.method2(text1,"Thread 2");
        };
        Runnable runnable3 = ()->{
            task1.method3(text1,"Thread 3");
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2= new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
// ожидать завершения других потоков исполнения
            Thread.sleep(10000);
        } catch (InterruptedException е) {
            System.out.println("Глaвный поток прерван");
        }
        System.out.println("Глaвный поток завершен.");
    }
}

