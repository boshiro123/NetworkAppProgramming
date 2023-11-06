import org.w3c.dom.ls.LSOutput;

import java.net.*;
import java.io.*;
class UDPServer {
    public void runServer() throws IOException {
        Integer r;
        try (DatagramSocket datagramSocket = new DatagramSocket(8001)){
            boolean stopFlag = false;
            System.out.println("UDPServer: Started on " + InetAddress.getLocalHost().getHostAddress()+ ":" + datagramSocket.getLocalPort());
            byte[] buf = new byte[512];
            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
                int n = 0;
            while (!stopFlag) {
                datagramSocket.receive(recvPacket);//читаем сообщения
                String cmd = new String(recvPacket.getData()).trim();
                System.out.println("UDPServer: Command: "+ new String(recvPacket.getData()).trim());
                DatagramPacket sendPacket = new DatagramPacket("0".getBytes(), 1, recvPacket.getAddress(), recvPacket.getPort());
               if (cmd.equals("kill")) {
                    stopFlag = true;//остановка работы сервера
                } else {
                    String word = transliterate(cmd);
                    n = word.getBytes().length;
                    System.out.println("UDPServer: Answer: " + word);
                    System.arraycopy(word.getBytes(), 0, buf, 0, n);
                }
                sendPacket.setData(buf);
                sendPacket.setLength(n);
                datagramSocket.send(sendPacket);
                buf = new byte[512];
                recvPacket = new DatagramPacket(buf, buf.length);
            }
            System.out.println("UDPServer: Stopped");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            UDPServer UDPServer = new UDPServer();
            UDPServer.runServer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
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
}