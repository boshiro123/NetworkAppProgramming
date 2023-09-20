import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FirstThread implements Runnable {
    String name; // имя потока исполнения
    String word;
    String text;
     Thread thread;

    FirstThread(String threadName, String text, String word) {
        name = threadName;
        thread = new Thread(this, name);
        System.out.println("Hoвый поток: " + thread);
        thread.start(); // запустить поток на исполнение
        this.word=word;
        this.text=text;
    }
    public void run() {
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
}