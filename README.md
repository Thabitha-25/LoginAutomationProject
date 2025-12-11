<<<<<<< HEAD
# LOGIN AUTOMATION PROJECT - Selenium Java

Automates the login functionality of https://the-internet.herokuapp.com/login using Selenium WebDriver, Java, CSV-based data-driven testing, and Page Object Model (POM). This is a plain Java project (no Maven, no TestNG).

---

## Project Structure

```
LoginAutomationProject/
├── lib/
│   ├── chromedriver.exe
│   ├── selenium-java JAR files
│   └── selenium-server JAR files
│
├── testdata/
│   └── loginData.csv
│
├── src/
│   └── com/
│       └── login/
│           ├── tests/
│           │   ├── BaseTest.java
│           │   ├── LoginTest.java
│           │   └── DataDrivenLoginTest.java
│           │
│           ├── pages/
│           │   └── LoginPage.java
│           │
│           └── utils/
│               ├── ConfigReader.java
│               └── CSVReader.java
│
├── config.properties
└── README.md
```

---

## Prerequisites

- Java JDK 17+
- Eclipse IDE
- Chrome Browser installed
- Selenium JARs added to `lib/`
- ChromeDriver version must match Chrome Browser

---

## Configuration (config.properties)

```properties
chromedriverPath=lib/chromedriver.exe
baseUrl=https://the-internet.herokuapp.com/login
implicitWait=10
```

---

## How to Add Selenium JARs

1. Right-click the project in Eclipse
2. Select Build Path then Configure Build Path
3. Click Add External JARs
4. Select all JAR files inside the lib folder

---

## Running Tests

### Manual Login Test

- File: src/com/login/tests/LoginTest.java
- Run as: Right-click then Run As then Java Application

---

### Data-Driven Login Test

- File: src/com/login/tests/DataDrivenLoginTest.java
- CSV file: testdata/loginData.csv
- Run as: Right-click then Run As then Java Application

---

## Data-Driven CSV Format

```csv
username,password,expected
tomsmith,SuperSecretPassword!,success
wrongusername,wrongpassword,invalid
,,empty
```

---

## Utilities

### ConfigReader.java

Loads `config.properties` values such as:
- ChromeDriver path
- Base URL
- Implicit wait

### CSVReader.java

Reads CSV from testdata/loginData.csv and returns a 2D String array.

---

## Page Object Model (LoginPage.java)

Example usage:

```java
LoginPage login = new LoginPage(driver);
login.enterUsername("tomsmith");
login.enterPassword("SuperSecretPassword!");
login.clickLogin();
```

---

## Notes

- No Maven
- No TestNG
- Uses Java assertions
- Works fully inside Eclipse IDE
- Plain Java project with manual JAR management

---

## Test Execution Flow

1. BaseTest.java - Sets up WebDriver with config
2. LoginTest.java - Single manual login test
3. DataDrivenLoginTest.java - Reads CSV and runs multiple scenarios

---

## Key Files

- LoginPage.java - Page Object Model for login page
- ConfigReader.java - Reads configuration properties
- CSVReader.java - Parses CSV test data
- config.properties - Central configuration file
- loginData.csv - Test data for data-driven testing

---

## Features

- Page Object Model (POM) design pattern
- Data-driven testing using CSV
- Configuration management via properties file
- Reusable utility classes
- Clean project structure
- No external build tools required
=======
# LoginAutomationProject
>>>>>>> branch 'main' of https://github.com/Thabitha-25/LoginAutomationProject.git
