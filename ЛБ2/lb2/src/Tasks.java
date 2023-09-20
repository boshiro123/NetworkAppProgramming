import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Tasks {
    public Tasks() {
    }
    public void method1(String text, String word, String name) {
        int count = 0;
        String[] words = text.split("\\s+");
        try {
            for (String w : words) {
                if (w.contains(word)) {
                    count++;
                    System.out.println("Найдено: " + count);
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException е) {
            System.out.println(name + " прерван");
        }
        String result = "Количество повторяющихся слов: " + count +"\n";
        System.out.println(result);
        System.out.println(name + " завершен.");
        try {
            Files.writeString(Paths.get("output.txt"),result, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void method2(String text, String name) {
        char[] charArray = text.toCharArray();
        char liter;
        try {
            Thread.sleep(1000);
            System.out.println(charArray);
            for (int i = 0; i < text.length() / 2; i++) {
                liter = charArray[i];
                charArray[i] = charArray[text.length() - i - 1];
                charArray[text.length() - i - 1] = liter;
            }
            Thread.sleep(2000);
        } catch (InterruptedException е) {
            System.out.println(name + " прерван");
        }
        System.out.println(charArray);
        String result = String.copyValueOf(charArray) + "\n";
        try {
            Files.writeString(Paths.get("output.txt"), result, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " завершен.");
    }

    public void method3(String text, String name) {
        int count = 0;
        try {
            count = text.length();
            Thread.sleep(2000);
        } catch (InterruptedException е) {
            System.out.println(name + " прерван");
        }
        String result = "Количество символов в тексте: " + count + "\n";
        try {
            Files.writeString(Paths.get("output.txt"), result, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);

        System.out.println(name + " завершен.");
    }
}
