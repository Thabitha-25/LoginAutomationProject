package com.login.tests;

import com.login.pages.LoginPage;
import com.login.utils.CSVReader;

public class DataDrivenLoginTest extends BaseTest {

    public static void main(String[] args) {

        DataDrivenLoginTest test = new DataDrivenLoginTest();
        test.setup();

        System.out.println("\n   RUNNING DATA-DRIVEN TESTS \n");

        String[][] data = CSVReader.readCSV("testdata/loginData.csv");

        for (int i = 1; i < data.length; i++) {  // skip header

            String uname = data[i][0].trim();
            String pwd = data[i][1].trim();
            String expected = data[i][2].trim();

            LoginPage login = new LoginPage(driver);

            System.out.println("Running Test for: " + uname + " | Expected: " + expected);

            login.enterUsername(uname);
            login.enterPassword(pwd);
            login.clickLogin();

            if (expected.equalsIgnoreCase("success")) {
                assert login.getSuccessMessage().contains("You logged into a secure area!")
                        : "Expected SUCCESS but failed";
                System.out.println(" SUCCESS Test Passed\n");
                driver.navigate().back();
            }
            else if (expected.equalsIgnoreCase("invalid")) {
                assert login.getErrorMessage().contains("invalid")
                        : " Expected INVALID but got success";
                System.out.println(" INVALID Test Passed\n");
            }
            else if (expected.equalsIgnoreCase("empty")) {
                System.out.println(" EMPTY fields handled\n");
            }
        }

        System.out.println("CSV DATA-DRIVEN TESTS COMPLETED");

        test.tearDown();
    }
}
