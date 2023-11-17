package banking.server;

import banking.LabEnvironment;
import banking.Utility;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain
{
    /**
     * Server application entry point.
     */
    public static void main(String[] args)
    {
        // Check lab mode
        if (!LabEnvironment.LAB_MODE)
            Utility.safePrintln("The server application is currently *not* running in lab mode.\n    Communication with the lab server is disabled.");

        // Check parameters
        if (args.length < 1
                || (args[0].equalsIgnoreCase("run") && args.length < 4)
                || (args[0].equalsIgnoreCase("generate") && args.length < 5))
        {
            // Show usage
            Utility.safePrintln("Usage:");
            Utility.safePrintln("    generate <database file> <mitm password file> <client configuration file> <attacker credentials file>");
            Utility.safePrintln("    run <database file> <ip> <port>");
            return;
        }

        // Generate new database?
        String argCommand = args[0];
        if (argCommand.equalsIgnoreCase("generate"))
        {
            // Create database file with given name and exit
            Database.generate(args[1], args[2], args[3], args[4]);
            Utility.safePrintln("Generating database file completed.");
            return;
        }
        else if (!argCommand.equalsIgnoreCase("run"))
        {
            Utility.safePrintln("Unknown command.");
            return;
        }

        // Parse remaining "run" parameters
        String ip = args[2];
        int port = Integer.parseInt(args[3]);

        // Read database
        Utility.safeDebugPrintln("Reading database file '" + args[1] + "'...");
        Database database = new Database(args[1]);

        // Create server socket
        Utility.safeDebugPrintln("Creating server socket...");
        try (ServerSocket serverSocket = new ServerSocket(port, 0, InetAddress.getByName(ip)))
        {
            // Listen for clients
            Utility.safeDebugPrintln("Enter client listen loop.");
            while (true)
            {
                // Accept new client
                Socket clientSocket = serverSocket.accept();
                Utility.safeDebugPrintln("Client accepted on port " + clientSocket.getLocalPort());

                // Start new thread to handle client
                new Thread(new ClientThread(clientSocket, database)).start();
            }
        } catch (IOException e)
        {
            Utility.printException(e);
        }
    }
}