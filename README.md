# Simple JSON Parsing in Test Automation Frameworks

This repository demonstrates how to parse JSON data using various libraries within Java-based test automation frameworks.


## Folder Structure

```
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── anilhorasan/
│   │               ├── JsonParser.java
│   │               ├── Main.java
│   │               └── User.java
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── anilhorasan/
│       │           ├── Gson_DataExtractionExampleTest.java
│       │           ├── Jackson_DataExtractionExampleTest.java
│       │           ├── JsonParserTest.java
│       │           ├── OrgJson_DataExtractionExampleTest.java
│       │           └── RestAssured_JsonPath_DataExtractionExampleTest.java
│       └── resources/
│           ├── dashboardCourses.json
│           └── exampleData_1.json
├── pom.xml
├── README.md
├── test.xml
```


## Simple JSON Object Examples

### Data 1: 

This JSON is used in JsonParserTest.java

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "age": 30
}
```

### Data 2: 
This JSON is used in all other tests except **JsonParserTest.java**.
```json
{
  "dashboard": {"purchaseAmount": 910, "website": "amazon.com"},
  "courses": [
    {"title": "Selenium Java", "price": 50, "copies":  6},
    {"title": "Cypress"      , "price": 40, "copies":  4},
    {"title": "RPA"          , "price": 45, "copies": 10}
  ]
}
```


## Libraries

### Jackson
Jackson is a popular library for processing JSON in Java. It offers a high-performance solution for reading and writing JSON.

### Gson
Gson is another popular library for converting Java objects to JSON and vice versa. It's widely used for its simplicity and ease of use.

### org.json
org.json is a lightweight library for working with JSON in Java. It provides a simple and flexible API for parsing and generating JSON.

### Rest Assured JsonPath
Rest Assured JsonPath is a powerful feature provided by the Rest Assured library for extracting and validating JSON data from REST API responses. It allows you to use JsonPath expressions to navigate and extract specific elements from JSON documents in a concise and readable manner.

## Features

- Examples using Jackson, Gson, and org.json
- Unit tests for each parsing method using JUnit and TestNG
- Sample JSON files for testing

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/anilhorasan/Simple-Json-Parsing-Test-Automation.git
   ```

2. Navigate to the project directory:
    ```bash
    cd Simple-Json-Parsing-Test-Automation
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

### Usage
* To run the unit tests:
    ```bash
    mvn test
    ```

* To add your own JSON parsing examples, create a new class in:
    ```bash
    src/main/java/com/anilhorasan/
    ```

## Contributing

Contributions are welcome!

### Steps to Contribute:
1. Fork the repository
2. Create a new branch
3. Implement your changes
4. Open a pull request


## Sources

- [Jackson GitHub Repository](https://github.com/FasterXML/jackson)
- [Gson GitHub Repository](https://github.com/google/gson)
- [org.json GitHub Repository](https://github.com/stleary/JSON-java)
- [Rest Assured - JSONPath GitHub Repository](https://github.com/rest-assured/rest-assured/tree/master/json-path)

### Additional Sources About JSON:

- [A curated list of awesome JSON libraries and resources.](https://github.com/burningtree/awesome-json?tab=readme-ov-file)
- [A tool to quickly parse JSON into Java maps and lists.](https://github.com/mitchhentges/json-parse)
- [Jayway JsonPath - A Java DSL for reading JSON documents.](https://github.com/json-path/JsonPath)

---
