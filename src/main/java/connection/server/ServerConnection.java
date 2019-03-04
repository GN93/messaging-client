package connection.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ServerConnection implements Serializable {

    private String hostname = "localhost";
    private int port = 6006;
    public Socket clientSocket;
    public static ServerConnection instance = new ServerConnection();
    private ServerConnection(){
        this.clientSocket = connect();
    }

    public String getHostname() {
        return hostname;
    }

    public static ServerConnection getInstance() {
        return instance;
    }

    public int getPort() {
        return port;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public Object readResolve(){
        return instance;
    }

    private Socket connect(){
        try(
              Socket clientSocket = new Socket("localhost", 6006);
//            Scanner in = new Scanner(clientSocket.getInputStream());
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true)
        ){
            System.out.println("Connection with server established!");
        }
        catch(IOException e){
            System.err.println("Unable to communicate with server: "+ instance.getHostname() + " on port: " + instance.getPort());
        }
        return clientSocket;
    }
}
