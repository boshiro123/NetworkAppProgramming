package Thread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultiClient2 {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        Scanner scanner = new Scanner(System.in);
        String str = "";
        try {
            // установка соединения с сервером
            socket = new Socket(InetAddress.getLocalHost(),8071);
            //или Socket socket = new Socket("ИМЯ_СЕРВЕРА",
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
            System.err.println("адрес недоступен" + e);
        } catch (IOException e) {
            System.err.println("ошибка I/О потока" + e);
        } catch (InterruptedException e) {
            System.err.println("ошибка потока выполнения" + e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}