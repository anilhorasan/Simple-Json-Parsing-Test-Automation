# Simple JSON Parsing in Test Automation Frameworks

This repository demonstrates how to parse JSON data using various libraries within Java-based test automation frameworks.

## Simple JSON Object Example

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "age": 30
}
```

This simple JSON object represents a user with the following attributes:

- **name**: The user's name.
- **email**: The user's email address.
- **age**: The user's age.

## Libraries

### Jackson
Jackson is a popular library for processing JSON in Java. It offers a high-performance solution for reading and writing JSON.

### Gson
Gson is another popular library for converting Java objects to JSON and vice versa. It's widely used for its simplicity and ease of use.

### org.json
org.json is a lightweight library for working with JSON in Java. It provides a simple and flexible API for parsing and generating JSON.

## Features

- Examples using Jackson, Gson, and org.json
- Unit tests for each parsing method
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

* To add your own JSON parsing examples, create a new class in 

    ```src/main/java/com/anilhorasan/.```

## Contributing

Contributions are welcome!


## Sources

- [Jackson GitHub Repository](https://github.com/FasterXML/jackson)
- [Gson GitHub Repository](https://github.com/google/gson)
- [org.json GitHub Repository](https://github.com/stleary/JSON-java)

---
