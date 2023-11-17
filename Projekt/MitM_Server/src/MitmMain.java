import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MitmMain
{
    /**
     * Server application entry point.
     */
    public static void main(String[] args)
    {
        // Address of the actual server
        String realServerIP = null; // TODO Insert server IP. Example: "[fde1:e7ed:da7a:1::1]"
        int realServerPort = 25383; // TODO Update this port each time the server is restarted

        // These values are given to the attacked client
        String localIp = null; // TODO Insert your IP. Example: "[fde1:e7ed:da7a:1:101::]"
        int localPort = 40000;

        // Some checks
        if (realServerIP == null)
            throw new NullPointerException("You forgot to set a server IP.");
        if (localIp == null)
            throw new NullPointerException("You forgot to set a local IP.");

        // Create server socket
        Utility.safeDebugPrintln("Creating server socket...");
        try (ServerSocket serverSocket = new ServerSocket(localPort, 0, InetAddress.getByName(localIp)))
        {
            // Listen for clients
            Utility.safeDebugPrintln("Enter client listen loop.");
            while (true)
            {
                // Create client socket
                Socket clientSocket = serverSocket.accept();
                Utility.safeDebugPrintln("Client accepted on port " + clientSocket.getLocalPort());

                // Create server socket
                Socket realServerSocket = new Socket(realServerIP, realServerPort);
                Utility.safeDebugPrintln("Real server connection created on port " + realServerSocket.getLocalPort());

                // Start threads to handle client and server packets
                new Thread(new ConnectionThread(clientSocket, realServerSocket, "Client")).start();
                new Thread(new ConnectionThread(realServerSocket, clientSocket, "Server")).start();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}