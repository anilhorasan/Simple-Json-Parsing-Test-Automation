package com.anilhorasan;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson_DataExtractionExampleTest {

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
    public void testJsonDataExtraction() throws IOException {
        // Read the JSON file
        File jsonFile = new File("src/test/resources/dashboardCourses.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        // 1. Extract and print number of courses
        int numberOfCourses = rootNode.path("courses").size();
        System.out.println("OBJECTIVE 1: ");
        System.out.println("Number of courses: " + numberOfCourses);

        // 2. Extract and print purchase amount
        double purchaseAmount = rootNode.path("dashboard").path("purchaseAmount").asDouble();
        System.out.println("OBJECTIVE 2: ");
        System.out.println("Purchase amount: " + purchaseAmount);

        // 3. Extract and print the title of the first course
        String firstCourseTitle = rootNode.path("courses").get(0).path("title").asText();
        System.out.println("OBJECTIVE 3: ");
        System.out.println("First course title: " + firstCourseTitle);

        // 4. Extract and print all course titles and prices
        System.out.println("OBJECTIVE 4: ");
        rootNode.path("courses").forEach(course -> {
            String title = course.path("title").asText();
            double price = course.path("price").asDouble();
            System.out.println("Course: " + title + "   ---   Price: " + price);
        });

        // 5. Find and print number of copies sold by RPA course
        boolean rpaFound = false;
        int rpaCopies = 0;
        for (JsonNode course : rootNode.path("courses")) {
            if ("RPA".equals(course.path("title").asText())) {
                rpaCopies = course.path("copies").asInt();
                rpaFound = true;
                break; // Exit loop once RPA course is found
            }
        }
        System.out.println("OBJECTIVE 5: ");
        if (rpaFound) {
            System.out.println("Copies sold by RPA: " + rpaCopies);
        } else {
            System.out.println("RPA course not found.");
        }

        // 6. Verify that purchase amount equals sum of prices * copies
        double totalPriceCopies = 0;
        for (JsonNode course : rootNode.path("courses")) {
            double price = course.path("price").asDouble();
            int copies = course.path("copies").asInt();
            totalPriceCopies += price * copies;
        }
        System.out.println("OBJECTIVE 6: ");
        System.out.println("Total of prices * copies: " + totalPriceCopies);

        // Use TestNG assertion
        Assert.assertEquals(purchaseAmount, totalPriceCopies, "Purchase amount does not match the total price * copies.");
    }
}
