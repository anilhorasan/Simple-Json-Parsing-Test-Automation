package com.anilhorasan;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Gson_DataExtractionExampleTest {

    /**
     * OBJECTIVE
     * 1. Print the number of the courses returned by the API
     * 2. Print the purchase amount
     * 3. Print the title of the first course
     * 4. Print all course titles and their prices
     * 5. Print the number of copies sold by the RPA course
     * 6. Verify that the purchase amount is equal to the sum of all course prices multiplied by their respective copies
     * DATA: dashboardCourses.json
     */

    @Test
    public void testJsonDataExtraction() throws Exception {
        // Read the JSON file as a String
        String jsonFilePath = "src/test/resources/dashboardCourses.json";
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

        // Parse the JSON using Gson
        JsonObject root = JsonParser.parseString(jsonContent).getAsJsonObject();

        // 1. Extract and print number of courses
        JsonArray courses = root.getAsJsonArray("courses");
        int numberOfCourses = courses.size();
        System.out.println("OBJECTIVE 1: ");
        System.out.println("Number of courses: " + numberOfCourses);

        // 2. Extract and print purchase amount
        double purchaseAmount = root.getAsJsonObject("dashboard").get("purchaseAmount").getAsDouble();
        System.out.println("OBJECTIVE 2: ");
        System.out.println("Purchase amount: " + purchaseAmount);

        // 3. Extract and print the title of the first course
        String firstCourseTitle = courses.get(0).getAsJsonObject().get("title").getAsString();
        System.out.println("OBJECTIVE 3: ");
        System.out.println("First course title: " + firstCourseTitle);

        // 4. Extract and print all course titles and prices
        System.out.println("OBJECTIVE 4: ");
        for (int i = 0; i < courses.size(); i++) {
            JsonObject course = courses.get(i).getAsJsonObject();
            String title = course.get("title").getAsString();
            double price = course.get("price").getAsDouble();
            System.out.println("Course: " + title + "   ---   Price: " + price);
        }

        // 5. Find and print number of copies sold by RPA course
        System.out.println("OBJECTIVE 5: ");
        int rpaCopies = 0;
        boolean rpaFound = false;
        for (int i = 0; i < courses.size(); i++) {
            JsonObject course = courses.get(i).getAsJsonObject();
            if ("RPA".equals(course.get("title").getAsString())) {
                rpaCopies = course.get("copies").getAsInt();
                rpaFound = true;
                break;
            }
        }
        if (rpaFound) {
            System.out.println("Copies sold by RPA: " + rpaCopies);
        } else {
            System.out.println("RPA course not found.");
        }

        // 6. Verify that purchase amount equals sum of prices * copies
        double totalPriceCopies = 0;
        for (int i = 0; i < courses.size(); i++) {
            JsonObject course = courses.get(i).getAsJsonObject();
            double price = course.get("price").getAsDouble();
            int copies = course.get("copies").getAsInt();
            totalPriceCopies += price * copies;
        }
        System.out.println("OBJECTIVE 6: ");
        System.out.println("Total of prices * copies: " + totalPriceCopies);

        // Assertion to verify purchase amount
        Assert.assertEquals(purchaseAmount, totalPriceCopies, "Purchase amount does not match the total price * copies.");
    }
}
