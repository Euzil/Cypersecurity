package banking.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Defines an action a user can do (like a server login).
 */
public abstract class Task
{
    /**
     * The socket input stream.
     */
    protected DataInputStream _socketInputStream;

    /**
     * The socket output stream.
     */
    protected DataOutputStream _socketOutputStream;

    /**
     * Creates a new task.
     *
     * @param socketInputStream  The socket input stream.
     * @param socketOutputStream The socket output stream.
     */
    public Task(DataInputStream socketInputStream, DataOutputStream socketOutputStream)
    {
        // Save parameters
        _socketInputStream = socketInputStream;
        _socketOutputStream = socketOutputStream;
    }

    /**
     * Executes the task.
     */
    public abstract void run() throws IOException;
}
