import javax.xml.crypto.Data;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerClientThread extends Thread{

    private Socket client; // client socket
    private char character; // X or O

    Scanner in;
    DataOutputStream out;

    public ServerClientThread(Socket incomingClient, int counter) {
        client = incomingClient;
        if (counter == 1) {
            character = 'X';
        } else {
            character = 'O';
        }
    }

    public void run() {
        try {
            Scanner in = new Scanner(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
            out.flush();

            String message = in.nextLine();
            System.out.println(message);
            // Test connection
//            out.writeBytes(character + " connected\n");
            out.flush();

            while (true) {
                message = in.nextLine();
                System.out.println(character + ": " + message);
            }


        } catch (Exception ex) {
            System.out.println("ServerClientThread: " + ex);
        }
    }

    public void tell(String msg) throws IOException {
        out.writeBytes(msg + "\n");
    }

}
