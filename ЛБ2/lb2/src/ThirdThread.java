import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ThirdThread implements Runnable {
    String name; // имя потока исполнения
    String text;
     Thread thread;

    ThirdThread(String threadName, String text) {
        name = threadName;
        thread = new Thread(this, name);
        System.out.println("Hoвый поток: " + thread);
        thread.start(); // запустить поток на исполнение
        this.text=text;
    }
    public void run() {
        int count = 0;
        try {
            count = text.length();
            Thread.sleep(2000);
        } catch (InterruptedException е) {
            System.out.println(name + " прерван");
        }
        String result = "Количество символов в тексте: " + count + "\n";
        try {
            Files.writeString(Paths.get("output.txt"),result, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);

        System.out.println(name + " завершен.");
    }
}