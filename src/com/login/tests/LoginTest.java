
package com.login.tests;

import com.login.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    public static void main(String[] args) {

        LoginTest testRunner = new LoginTest();
        testRunner.setup();

        LoginPage login = new LoginPage(driver);

        System.out.println("\n  RUNNING MANUAL TEST CASES \n");

        // TEST CASE 1: VALID LOGIN
        System.out.println(" Test Case 1: Valid Login");
        login.enterUsername("tomsmith");
        login.enterPassword("SuperSecretPassword!");
        login.clickLogin();

        assert login.getSuccessMessage().contains("You logged into a secure area!")
                : " Valid login failed";

        System.out.println(" Valid Login Passed\n");
        driver.navigate().back();

        // TEST CASE 2: INVALID LOGIN
        System.out.println("Test Case 2: Invalid Login");
        login.enterUsername("wrongusername");
        login.enterPassword("wrongpassword");
        login.clickLogin();

        assert login.getErrorMessage().contains("Your username is invalid!")
                : " Invalid login error not displayed ";

        System.out.println("Invalid Login Test Passed\n");

        // TEST CASE 3: EMPTY FIELDS
        System.out.println(" Test Case 3: Empty Fields");
        login.enterUsername("");
        login.enterPassword("");
        login.clickLogin();

        WebElement usernameField = driver.findElement(By.id("username"));
        String validationMsg = usernameField.getAttribute("validationMessage");

        assert !validationMsg.isEmpty() : "Empty field validation missing";

        System.out.println("Empty Fields Validation Passed\n");

        System.out.println("ALL MANUAL TEST CASES PASSED ");

        testRunner.tearDown();
    }
}
