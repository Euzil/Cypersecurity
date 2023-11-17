package banking.server;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Contains the data of one user.
 */
public class UserData
{
    /**
     * The user's name.
     */
    private final String _name;

    /**
     * The user's password.
     */
    private final String _password;

    /**
     * The user's device codes.
     */
    private final List<String> _deviceAuthenticationStrings;

    /**
     * Determines the scenario to be marked as "solved" when this user looses money.
     * -1 means no scenario.
     */
    private final int _scenarioId;

    /**
     * The history of money changes on this account.
     */
    private final List<Tuple<Integer, Integer>> _moneyHistory;

    /**
     * The user's amount of money.
     */
    private int _money;

    /**
     * Reads the user data from the given JSON object.
     */
    public UserData(JsonObject userDataObj)
    {
        // Read attributes
        _name = userDataObj.get("name").asString();
        _password = userDataObj.get("password").asString();
        _money = userDataObj.get("money").asInt();
        _scenarioId = userDataObj.get("scenario").asInt();

        // Read device list
        _deviceAuthenticationStrings = Collections.synchronizedList(new ArrayList<>());
        for (JsonValue val : userDataObj.get("devices").asArray())
            if (val.isString())
                _deviceAuthenticationStrings.add(val.asString());

        // Initialize empty history
        _moneyHistory = Collections.synchronizedList(new ArrayList<>());
    }

    /**
     * Creates a new user with the given properties.
     *
     * @param name       The new user's name.
     * @param password   The new user's password.
     * @param money      The new user's amount of money.
     * @param scenarioId Determines the scenario to be marked as "solved" when this
     *                   user looses money. -1 means no scenario.
     */
    public UserData(String name, String password, int money, int scenarioId)
    {
        _name = name;
        _password = password;
        _money = money;
        _scenarioId = scenarioId;
        _deviceAuthenticationStrings = Collections.synchronizedList(new ArrayList<>());

        // Initialize empty history
        _moneyHistory = Collections.synchronizedList(new ArrayList<>());
    }

    /**
     * Saves the user's data into a JSON object. Only used for generating database
     * files.
     *
     * @return A JSON object with the user's data.
     */
    public JsonObject toJson()
    {
        // Put device list into JSON array
        JsonArray deviceArray = new JsonArray();
        for (String device : _deviceAuthenticationStrings)
            deviceArray.add(device);

        // Create user data JSON object
        JsonObject obj = new JsonObject();
        obj.add("name", _name);
        obj.add("password", _password);
        obj.add("money", _money);
        obj.add("devices", deviceArray);
        obj.add("scenario", _scenarioId);
        return obj;
    }

    /**
     * Returns the user's name.
     *
     * @return The user's name.
     */
    public String getName()
    {
        return _name;
    }

    /**
     * Returns the scenario to be marked as "solved" when this user looses money. -1
     * means no scenario.
     *
     * @return The scenario to be marked as "solved" when this user looses money. -1
     * means no scenario.
     */
    public int getScenarioId()
    {
        return _scenarioId;
    }

    /**
     * Checks whether the given password is valid for this user.
     *
     * @param password The password of the user.
     * @return A boolean value indicating whether the given password is valid for
     * this user.
     */
    public boolean checkPassword(String password)
    {
        try
        {
            // Compare passwords
            for (int i = 0; i < password.length(); ++i)
            {
                // Matching character?
                if (password.charAt(i) != _password.charAt(i))
                    return false;

                // Make brute force attacks inefficient
                Thread.sleep(500);
            }
            return true;
        } catch (Exception ex)
        {
            return false;
        }
    }

    /**
     * Returns the user's amount of money.
     *
     * @return The user's amount of money.
     */
    public int getMoney()
    {
        return _money;
    }

    /**
     * Changes the amount of money this user has, and tracks the change in the
     * history.
     *
     * @param userId The ID of the changing user.
     * @param money  The amount of money added (positive value) or removed (negative
     *               value) from this user. This function simply does an addition,
     *               the checks must be done by the caller!
     */
    public void changeMoney(int userId, int money)
    {
        // Add history entry
        _moneyHistory.add(new Tuple<>(userId, money));

        // Update money amount
        _money += money;
    }

    /**
     * Returns a list containing the user's full money sending/receiving history.
     *
     * @return A list containing the given user's full money sending/receiving
     * history.
     */
    public List<Tuple<Integer, Integer>> getMoneyHistory()
    {
        return _moneyHistory;
    }

    /**
     * Adds the device with the given authentication code.
     *
     * @param deviceCode The device code to be added.
     */
    public void addDevice(String deviceCode)
    {
        // Add device
        _deviceAuthenticationStrings.add(deviceCode);
    }

    /**
     * Checks whether this user has a device with the given code.
     *
     * @param deviceCode The device code to be searched.
     * @return Whether this user has a device with the given code.
     */
    public boolean hasDevice(String deviceCode)
    {
        // Find device
        for (String code : _deviceAuthenticationStrings)
            if (code.equalsIgnoreCase(deviceCode))
                return true;
        return false;
    }
}
