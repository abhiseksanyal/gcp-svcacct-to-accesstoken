package com.abhiseksanyal;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;

public class App 
{
    public static void main( String[] args )
    {
        if (args.length != 1) {
            System.out.println("Pass the service account key file as the first parameter");
            System.exit(1);
        }
        try {
            // Based on example given here - 
            // https://github.com/googleapis/google-auth-library-java#explicit-credential-loading
            // NOTE: Directly using the example raised the following exception,
            // com.google.auth.oauth2.GoogleAuthException: Error getting access token for service account:
            // 400 Bad Request POST https://oauth2.googleapis.com/token
            // {"error":"invalid_scope","error_description":"Invalid OAuth scope or ID token audience provided."}
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(args[0]));
            Collection<String> scopedData = new ArrayList<String>();
            // Scope based on information here - 
            // https://cloud.google.com/compute/docs/access/service-accounts#scopes_best_practice
            scopedData.add("https://www.googleapis.com/auth/cloud-platform");
            // Access token could be fetched when a credential with scope was used
            GoogleCredentials scopedCredentials = credentials.createScoped(scopedData);
            scopedCredentials.refreshIfExpired();
            AccessToken token = scopedCredentials.getAccessToken();
            // OR AccessToken token = credentials.refreshAccessToken();
            System.out.printf("Token is %s\n", token.getTokenValue());
            System.out.printf("Token expiration time is %s\n", token.getExpirationTime());
        } catch (java.io.IOException e) {
            System.out.printf("Error in converting to access token - %s", e.toString());
        }
    }
}
