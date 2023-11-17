package banking.client;

import banking.Utility;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

import java.io.FileReader;
import java.io.IOException;

/**
 * Contains client configuration.
 */
public class ClientConfiguration
{
    /**
     * The implementation version.
     */
    private String _version;

    /**
     * Reads the configuration data from the given JSON file.
     */
    public ClientConfiguration(String configurationFilePath)
    {
        try (FileReader jsonFileReader = new FileReader(configurationFilePath))
        {
            // Retrieve root object
            JsonObject rootObj = Json.parse(jsonFileReader).asObject();

            // Read data
            _version = rootObj.get("version").asString();
        } catch (IOException e)
        {
            Utility.printException(e);
        }
    }

    /**
     * Returns the implementation version.
     *
     * @return The implementation version.
     */
    public String getVersion()
    {
        return _version;
    }
}
