import connection.server.ServerConnection;
import message.Message;
import message.MessageType;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList recipents = new ArrayList();
        recipents.add("serwer");
        Message message = new Message(MessageType.ONE_TO_ONE, "Cześć serwerze!",recipents);
        ServerConnection serverConnection = ServerConnection.getInstance();
        Socket clientSocket = serverConnection.getClientSocket();


        try(
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        ){
            oos.writeObject(message);
        } catch (IOException e){
            System.out.println("Unable to get input or output stream towards server.");
        }
    }
}
