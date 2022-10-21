import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author: Michael Frank
 */




public class Main {

    static volatile boolean serverStarted = false;

    public static void main(String[] args) {

        IoHandler ioHandler = IoHandler.getInstance();

        while (!ioHandler.getCurrentInput().equals("host") && !ioHandler.getCurrentInput().equals("join")) {
            System.out.print("Would you like to host or join an existing game?\n> ");
            ioHandler.scanInput();
        }

        if (ioHandler.getCurrentInput().equals("host")) {
            System.out.println("Starting in host mode...");

            /*
              It is unnecessarily difficult to obtain the current host's
              IP address in java. For some reason you have to create a new
              socket and try connecting to a random address first.
              Whatever, though... it works.
             */
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress("google.com", 80));
                String hostIP =  socket.getLocalAddress().getHostAddress();
                System.out.println("Your IP address is " + hostIP);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            startServer();

            /*
              Do not start the client until the server is started.
              This is vital because both are run as threads and the
              order they run in is not guaranteed. If the client
              attempts to connect to the server before it exists,
              it will throw an error and the program will exit.
             */
            while (!serverStarted) Thread.onSpinWait();
            startClient();

        }


        else {
            System.out.println("Starting in client mode...");
        }
    }

    private static void startServer() {
        (new Thread(() -> (new ClientServer()).setupServer())).start();
    }

    private static void startClient() {
        (new Thread(() -> (new ClientServer()).setupClient())).start();
    }

    public static void setServerStarted(boolean serverStarted) {
        Main.serverStarted = serverStarted;
    }
}
