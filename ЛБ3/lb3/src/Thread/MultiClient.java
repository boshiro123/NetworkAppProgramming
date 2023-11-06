package Thread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultiClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        Scanner scanner = new Scanner(System.in);
        String str = "";
        try {
            socket = new Socket(InetAddress.getLocalHost(),8072);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(str!=null){
                System.out.print("Слово для перевода: ");
                ps.println(scanner.nextLine());
                str = br.readLine();
                System.out.println("Ответ с сервера: " + str);
                Thread.sleep(1_000);
            }
        } catch (UnknownHostException e) {
            // если не удалось соединиться с сервером
            System.err.println("Адрес недоступен" + e);
        } catch (IOException e) {
            System.err.println("Ошибка I/О потока" + e);
        } catch (InterruptedException e) {
            System.err.println("Ошибка потока выполнения" + e);
        }
    }
}