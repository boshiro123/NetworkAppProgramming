import java.io.*;
import java.net.*;
class ServerFirst {
    public static void main(String[] arg) {
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;
        ObjectInputStream sois = null;
        ObjectOutputStream soos =null;
        try {
            serverSocket = new ServerSocket(2525); System.out.println("server starting....");
            System.out.println("at IP="+InetAddress.getLocalHost().getHostAddress());
            System.out.println("at port="+serverSocket.getLocalPort());
            clientAccepted = serverSocket.accept();
            System.out.println("connection established....");
            System.out.println("with IP="+ clientAccepted.getInetAddress());
            System.out.println("at port="+clientAccepted.getPort());
            sois=new ObjectInputStream(clientAccepted.getInputStream());
            soos=new ObjectOutputStream(clientAccepted.getOutputStream());
            String clientMessageRecieved = (String) sois.readObject();
            while (!clientMessageRecieved.equals("quite")){ System.out.println("message recieved:" +
                    clientMessageRecieved);
                clientMessageRecieved=clientMessageRecieved.toUpperCase();
                soos.writeObject(clientMessageRecieved);
                clientMessageRecieved = (String) sois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
        } finally {
            try {
                if (sois != null)sois.close();
                if (soos != null) soos.close();
                if (clientAccepted !=
                        null)clientAccepted.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                System.out.println("Ресурсы не закрыты!!!");
            }
        }
    }
}