package com.byoskill.training.junit.schoolboard;

/**
 * Contains the information required to perform the authentication
 */
public class UserToken {
    private final String userName;
    private final String password;

    /**
     * Builds the user token
     * @param userName the user name
     * @param password the password
     */
    public UserToken(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String forgeToken() {
        return userName.hashCode() + "-" + password.hashCode();
    } 
}
