package com.anilhorasan;

/**
 * Main class that demonstrates how to parse JSON data using different libraries:
 * - Jackson
 * - Gson
 * - org.json
 *
 * This class serves as a simple entry point for demonstrating JSON parsing with multiple libraries.
 * It takes a sample JSON string, parses it using each of the three libraries, and prints the results to the console.
 *
 * The purpose of this class is to provide examples of parsing JSON data in a way that can be reused in test automation
 * frameworks, helping developers and testers choose the appropriate library for their needs and see how parsing is done.
 */
public class Main {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"John Doe\", \"email\":\"john.doe@example.com\", \"age\":30}";

        try {
            // Parsing with Jackson
            User userJackson = JsonParser.parseWithJackson(jsonString, User.class);
            System.out.println("Parsed with Jackson: " + userJackson);

            // Parsing with Gson
            User userGson = JsonParser.parseWithGson(jsonString, User.class);
            System.out.println("Parsed with Gson: " + userGson);

            // Parsing with org.json
            System.out.println("Parsed with org.json: " + JsonParser.parseWithOrgJson(jsonString).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
