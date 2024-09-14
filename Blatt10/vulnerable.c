#include <stdio.h>

char *usernames[5] = {
    "wolfgang",
    "mona",
    "chef",
    "lisa",
    "amadeus"
};

int digitToIntLookup[10] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

int pins[5][4] = {
    { 2, 2, 3, 4 },
    { 4, 2, 4, 3 },
    { 9, 9, 7, 9 },
    { 1, 3, 3, 7 },
    { 2, 4, 6, 8 }
};

int securityLevels[5] = { 2, 1, 4, 3, 1 };

char getCharAtIndex(char *str, int index)
{
    return str[index];
}

int digitToInt(char digit)
{
    // Use lookup table to translate ASCII digit to integer
    return digitToIntLookup[digit - '0']; // Get offset in lookup table
}

int login()
{
    // Read user name
    printf("User: ");
    char username[4096]; // Enough memory to avoid buffer overflows even for very long user names
    if(gets(username) == 0)
        return 0;

    // Read password
    printf("PIN: ");
    char pinString[4096]; // same here
    if(gets(pinString) == 0)
        return 0;

    // Find user with given name
    int usernameLength = strlen(username);
    int userId = -1;
    for(int u = 0; u < 5; ++u)
    {
        // Matching user name?
        int match = 1;
        for(int i = 0; i < usernameLength; ++i)
        {
            // Does the current input char match the corresponding one in the user name?
            if(getCharAtIndex(usernames[u], i) != getCharAtIndex(username, i))
            {
                match = 0;
                break;
            }
        }
        if(match == 1)
        {
            userId = u;
            break;
        }
    }

    // User found?
    if(userId == -1)
        return 0;

    // Convert input PIN into integer representation
    int pin[4];
    for(int i = 0; i < 4; ++i)
        pin[i] = digitToInt(pinString[i]);

    // Compare PIN
    for(int i = 0; i < 4; ++i)
        if(pin[i] != pins[userId][i])
            return 0;
    return 1;
}

int main()
{
    // ... Code ...

    printf("Welcome at ITS context switch counting system!\n");
    if(login() == 0)
    {
        // Error message
        printf("Access denied.\n");

        // Block IP address for 1 hour
        // Code...

        // Kill connection
        return 0;
    }
    printf("Access granted.\n");

    // ... Code ...
}