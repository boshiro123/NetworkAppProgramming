import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SecondThread implements Runnable {
    String name; // имя потока исполнения
    String text;
     Thread thread;

    SecondThread(String threadName, String text) {
        name = threadName;
        thread = new Thread(this, name);
        System.out.println("Hoвый поток: " + thread);
        thread.start(); // запустить поток на исполнение
        this.text=text;
    }
    public void run() {
        char[] charArray = text.toCharArray();
        char liter;
        try {
            Thread.sleep(1000);
            System.out.println(charArray);
            for (int i = 0; i<text.length()/2;i++) {
                liter=charArray[i];
                charArray[i]=charArray[text.length()-i-1];
                charArray[text.length()-i-1]=liter;
            }
            Thread.sleep(2000);
        } catch (InterruptedException е) {
            System.out.println(name + " прерван");
        }
        System.out.println(charArray);
        String result = String.copyValueOf(charArray) + "\n";
        try {
            Files.writeString(Paths.get("output.txt"),result, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " завершен.");
    }
}