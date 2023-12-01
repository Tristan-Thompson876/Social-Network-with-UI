package p2;

import java.util.HashMap;

/**
 * Represents a login mechanism for a system, managing user login credentials.
 */
public class Login {

    // HashMap to store username and password information
    private HashMap<String, String> loginInfo = new HashMap<String, String>();

    /**
     * Constructor for the Login class.
     * Initializes the login information with predefined users.
     */
    public Login() {
        // Predefined user credentials
        loginInfo.put("Carl long", "12345678/620157742");
        loginInfo.put("Tris tall", "1/620157741");
        loginInfo.put("Can This", "34242593/620157743");
        loginInfo.put("nick gan", "50600302/620157744");
    }

    /**
     * Retrieves the login information.
     * 
     * @return A HashMap containing login credentials with usernames as keys and passwords as values.
     */
    public HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }

}
