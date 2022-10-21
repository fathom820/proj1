import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientServer
{
    Socket clientSocket;

    ServerSocket serverSocket;

    int currentConnections = 0;

    public void setupServer()
    {
        try
        {
            // Everything up through bind
            serverSocket = new ServerSocket(4446);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try
        {
            // Have the server listen and accept if someone tries to connect.
            System.out.println("Starting local server");
            Main.setServerStarted(true);
            Socket incomingClient = serverSocket.accept();

            Scanner in = new Scanner(incomingClient.getInputStream());

            DataOutputStream out = new DataOutputStream(incomingClient.getOutputStream());
            out.flush();

            String message = in.nextLine();
            System.out.println(message);
            // Test connection
            out.writeBytes("[Server] Hello Client\n");

            TicTacToe game = new TicTacToe();

            while (true) {
                message = in.nextLine();
                System.out.println(message);
            }



            // If the client closes the connection if all goes well I will realize
            // it as well and my side will be closed automatically.

            // If I fail to realize the connection was closed then I may accidentally
            // leave it running and waste resources.  Why it is good to send "Are You There?"
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setupClient()
    {

        try
        {
            System.out.println("Starting client");
            // Setup a socket that will try to connect to a specific address
            // and port number.
            clientSocket = new Socket("127.0.0.1", 4446);

            // First the client sets up its send connection
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            out.flush();

            Scanner in = new Scanner(clientSocket.getInputStream());

            out.writeBytes("[Client] Hello Server\n");

            while (true) {
                String message = in.nextLine();
                System.out.println(message);
            }


            // Done talking
//            clientSocket.close();

        }
        catch (UnknownHostException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}