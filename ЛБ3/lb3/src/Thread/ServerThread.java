package Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

class ServerThread extends Thread {
    private PrintStream os;
    private BufferedReader is;
    private InetAddress addr; // адрес клиента
     private static int counter = 0;
    public ServerThread(Socket s) throws IOException {
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        addr = s.getInetAddress();
        counter++;
    }
    public static int getCounter() { return counter;}
    public static String transliterate(String russianText) {
        String englishText = "";
        String[] russianLetters = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};
        String[] englishLetters = {"a", "b", "v", "g", "d", "e", "yo", "zh", "z", "i", "y", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "ts", "ch", "sh", "sch", "", "y", "", "e", "yu", "ya"};

        for (int i = 0; i < russianText.length(); i++) {
            char currentChar = russianText.charAt(i);
            String currentLetter = Character.toString(currentChar);
            for (int j = 0; j < russianLetters.length; j++) {
                if (currentLetter.equalsIgnoreCase(russianLetters[j])) {
                    englishText += englishLetters[j];
                    break;
                }
                if (j==russianLetters.length-1) {
                    englishText += russianText.charAt(i);
                }
            }
        }
        return englishText;
    }
    public void run() {
        int i = 0;
        String str;
        try {
            while (!(str = is.readLine()).equals("kill")) {
                System.out.println("От клиента: " + str);
                str = transliterate(str);
                    os.println(str);
                System.out.println("Ответ: " + str);//" " + i + " with " + addr.getHostName());
            }
        } catch (IOException e) {
            // если клиент не отвечает, соединение с ним разрывается
            System.err.println("Disconnect");
        }
        finally {
            disconnect(); // уничтожение потока
             }
        }
        public void disconnect() {
            try {
                if (os != null) {
                    os.close();
                }
                if (is != null) {
                    is.close();
                }
                System.out.println(addr.getHostName() + " disconnecting");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                this.interrupt();
            }
        }
    }