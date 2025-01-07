package com.anilhorasan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

import io.restassured.path.json.JsonPath;

class JsonParserTest {

	private static final String dataFile = "exampleData_1.json";

	private String getJsonData() throws IOException, URISyntaxException {
	    // Ensure the path is relative to the "resources" folder
	    URL resource = getClass().getClassLoader().getResource(dataFile);
	    if (resource == null) {
	        throw new IllegalArgumentException("File not found! " + dataFile);
	    }
	    return new String(Files.readAllBytes(Paths.get(resource.toURI())));
	}

    // --- Positive Tests (Everything is going to be awesome!) ---

    @Test
    void testParseWithJackson() {
        try {
            String jsonString = getJsonData(); // Fetch the JSON string
            User user = JsonParser.parseWithJackson(jsonString, User.class);
            assertNotNull(user, "Jackson couldn't parse the JSON? Unbelievable!");
            assertEquals("John Doe", user.getName(), "Jackson, you had one job: get the name right.");
            assertEquals("john.doe@example.com", user.getEmail(), "Jackson, this better be the correct email.");
            assertEquals(30, user.getAge(), "Seriously, Jackson, this age is not rocket science.");
        } catch (IOException e) {
            fail("Error reading JSON data from file: " + e.getMessage());
        } catch (Exception e) {
            fail("Exception occurred while parsing JSON with Jackson: " + e.getMessage());
        }
    }

    @Test
    void testParseWithGson()  {
        try {
            String jsonString = getJsonData(); // Fetch the JSON string
            User user = JsonParser.parseWithGson(jsonString, User.class); // Use Gson to parse the JSON
            assertNotNull(user, "Gson failed to parse the JSON? That’s just sad.");
            assertEquals("John Doe", user.getName(), "Gson, I thought you were smarter than this!");
            assertEquals("john.doe@example.com", user.getEmail(), "Gson, really? This email is as clear as day.");
            assertEquals(30, user.getAge(), "How old is this user again? It better be 30.");
        } catch (URISyntaxException | IOException e) {
            fail("Error reading JSON data from file: " + e.getMessage());
        }
    }

    @Test
    void testParseWithOrgJson() {
        try {
            String jsonString = getJsonData();  // Fetch the JSON string
            JSONObject jsonObject = JsonParser.parseWithOrgJson(jsonString); // Use org.json to parse the JSON
            // Assertions to verify the extracted data
            assertNotNull(jsonObject, "org.json can't even handle this simple JSON?");
            assertEquals("John Doe", jsonObject.getString("name"), "org.json, I expect better from you.");
            assertEquals("john.doe@example.com", jsonObject.getString("email"), "Are you sure this is the correct email?");
            assertEquals(30, jsonObject.getInt("age"), "30? Or is it 40? Let's check again.");
        } catch (URISyntaxException | IOException e) {
            fail("Error reading JSON data from file: " + e.getMessage());
        }
    }

    @Test
    void testParseWithRestAssured() {
        try {
            String jsonString = getJsonData();  // Fetch the JSON string
            JsonPath jsonPath = new JsonPath(jsonString);  // Use Rest Assured's JsonPath to parse the JSON
            // Assertions to verify the extracted data
            assertNotNull(jsonPath, "json should not be null.");
            assertEquals("John Doe", jsonPath.getString("name"), "Rest Assured, you had one job: get the name right.");
            assertEquals("john.doe@example.com", jsonPath.getString("email"), "Rest Assured, this better be the correct email.");
            assertEquals(30, jsonPath.getInt("age"), "Seriously, Rest Assured, this age is not rocket science.");
        } catch (Exception e) {
            throw new AssertionError("Error occurred while parsing JSON with Rest Assured: " + e.getMessage());
        }
    }

    // --- Negative Tests (Oops, things didn’t go as planned...) ---

    @Test
    void testInvalidJsonWithJackson() {
        // Invalid JSON string to test error handling
    	// This test utilizes src/main/java/com/anilhorasan/User.java
        String invalidJson = "{\"name\":\"John Doe\", \"email\":\"john.doe@example.com\", \"age\":}";
        try {
            JsonParser.parseWithJackson(invalidJson, User.class);
            fail("Expected an exception for invalid JSON, but Jackson just shrugged and carried on.");
        } catch (Exception e) {
            // Expected exception
            assertTrue(e instanceof com.fasterxml.jackson.databind.exc.MismatchedInputException,
                "Oops, Jackson didn't even break a sweat. Something's wrong!");
        }
    }
}
