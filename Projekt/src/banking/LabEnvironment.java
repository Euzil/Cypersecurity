package banking;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Provides methods that interact with the lab environment.
 * DO NOT CHANGE THIS CLASS.
 */
public class LabEnvironment
{
    /**
     * Controls whether we are in lab or testing mode. Lab mode enables
     * communication features like sending confirmation codes, and suppresses debug output (except when explicitly requested).
     */
    public final static boolean LAB_MODE;

    /**
     * Output file for debug information in lab mode (for program validation).
     */
    public static final FileWriter DEBUG_FILE;

    /**
     * The authentication used for communication with the main server.
     */
    private final static String API_TOKEN;

    /*
     * Initializes constant fields.
     */
    static
    {
        // Initialize LAB_MODE field
        String labMode = System.getProperty("LAB_MODE");
        if (labMode != null)
            LAB_MODE = Boolean.parseBoolean(labMode);
        else
            LAB_MODE = false;

        // Open debug output file
        String debugFileName = System.getProperty("DEBUG_FILE");
        FileWriter debugFile = null;
        if (debugFileName != null && !debugFileName.isBlank())
        {
            try
            {
                debugFile = new FileWriter(debugFileName);
            } catch (IOException e)
            {
                // Show error
                Utility.printException(e);
            }
        }
        DEBUG_FILE = debugFile;

        // Initialize API_TOKEN field
        String apiToken = System.getProperty("API_TOKEN");
        API_TOKEN = apiToken != null ? apiToken : "no-token";
    }

    /**
     * Sends the confirmation code to the lab server. The confirmation code also is
     * always printed to the console.
     *
     * @param userName         The associated username.
     * @param confirmationCode The confirmation to be sent/displayed.
     */
    public static void sendConfirmationCode(String userName, String confirmationCode)
    {
        // Print code to stdout
        Utility.safePrintln("Generated confirmation code for " + userName + ": >>" + confirmationCode + "<<");

        // Notify server, if in lab
        if (LAB_MODE)
        {
            HttpsURLConnection con = null;
            try
            {
                // Build API request body
                String jsonRequest = "{ \"ApiToken\": \"" + API_TOKEN + "\", \"User\": \"" + userName + "\", \"ConfirmationCode\": \"" + confirmationCode + "\" }";

                // Connect
                con = (HttpsURLConnection) new URL("https://teaching.its.uni-luebeck.de/cs/lab/project/api/confirmationcode").openConnection();
                con.setDoOutput(true);
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", "BankingClient");
                con.setRequestProperty("Content-Type", "application/json");

                // Send request
                try (DataOutputStream requestStream = new DataOutputStream(con.getOutputStream()))
                {
                    requestStream.write(jsonRequest.getBytes(StandardCharsets.UTF_8));
                }

                int statusCode = con.getResponseCode();

                // Read response
                StringBuilder response = new StringBuilder();
                try (BufferedReader responseStream = new BufferedReader(new InputStreamReader(con.getInputStream())))
                {
                    String line;
                    while ((line = responseStream.readLine()) != null)
                        response.append(line).append("\n");
                }

                // Debug
                Utility.safeDebugPrintln("  Lab server responded: \n" + response);

                if (statusCode >= 400)
                    throw new Exception("    Request failed with status " + statusCode);
            } catch (Exception e)
            {
                // Show error
                Utility.printException(e);
            } finally
            {
                // Make sure to disconnect
                if (con != null)
                    con.disconnect();
            }
        }
    }

    /**
     * Notifies the lab server that the given group solved the given scenario.
     *
     * @param scenario The scenario ID.
     */
    public static void notifyScenarioSolved(int scenario)
    {
        // Show notification
        Utility.safePrintln("Group solved scenario #" + scenario);

        // Notify server, if in lab
        if (LAB_MODE)
        {
            HttpsURLConnection con = null;
            try
            {
                // Build API request body
                String jsonRequest = "{ \"ApiToken\": \"" + API_TOKEN + "\", \"ScenarioId\": " + scenario + " }";

                // Connect
                con = (HttpsURLConnection) new URL("https://teaching.its.uni-luebeck.de/cs/lab/project/api/submitscenario").openConnection();
                con.setDoOutput(true);
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", "BankingClient");
                con.setRequestProperty("Content-Type", "application/json");

                // Send request
                try (DataOutputStream requestStream = new DataOutputStream(con.getOutputStream()))
                {
                    requestStream.write(jsonRequest.getBytes(StandardCharsets.UTF_8));
                }

                int statusCode = con.getResponseCode();

                // Read response
                StringBuilder response = new StringBuilder();
                try (BufferedReader responseStream = new BufferedReader(new InputStreamReader(con.getInputStream())))
                {
                    String line;
                    while ((line = responseStream.readLine()) != null)
                        response.append(line).append("\n");
                }

                // Debug
                Utility.safePrintln("  Lab server responded: " + response);

                if (statusCode >= 400)
                    throw new Exception("    Request failed with status " + statusCode);
            } catch (Exception e)
            {
                // Show error
                Utility.printException(e);
            } finally
            {
                // Make sure to disconnect
                if (con != null)
                    con.disconnect();
            }
        }
    }
}
