package com.byoskill.training.junit.schoolboard;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * This service is in charge to check the username and the password passed by the user before getting access to the SchoolBoard.
 */
public class AuthenticationService {

    private final String serviceUrl = "https://externalservice/auth";

    public void controlAccess(UserToken userToken) throws IllegalAccessException {
        if (userToken != null && authenticate(userToken)) return;
        throw new IllegalAccessException("Access has been denied.");
    }

    public boolean authenticate(UserToken token) {
        try {
            final URL url = new URL(serviceUrl + "?token=" + token.forgeToken());
            final URLConnection urlConnection = url.openConnection();
            return (urlConnection.getContentLength() != 0);
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + serviceUrl);
        } catch (IOException e) {
            System.err.println("Authentication has failed or the service is unavailable " + serviceUrl);
        }
        return false;
    }
}
