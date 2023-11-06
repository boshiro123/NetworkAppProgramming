import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

class UDPClient {
    public void runClient() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String request = "";
        String answer = "";
        try (DatagramSocket s = new DatagramSocket()) {
            byte[] buf = new byte[512];
            System.out.println("UDPClient: Started");
            DatagramPacket sendPacket;
            DatagramPacket recvPacket = new DatagramPacket(buf,buf.length);
            while(!request.equals("kill")) {
                System.out.print("Command: ");
                request = scanner.nextLine();
                byte[] quitCmd = request.getBytes();
                sendPacket = new DatagramPacket(quitCmd, quitCmd.length, InetAddress.getByName("127.0.0.1"), 8001);
                s.send(sendPacket);
                s.receive(recvPacket);
                answer = new String(recvPacket.getData()).trim();
                System.out.println("Message from server: " + answer);
               buf = new byte[512];
                recvPacket = new DatagramPacket(buf,buf.length);
            }
            //послать данные серверу
             System.out.println("UDPClient: Ended");
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            UDPClient client = new UDPClient();
            client.runClient();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}