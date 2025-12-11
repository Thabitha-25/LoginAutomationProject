package com.login.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties loadProperties() {

        Properties prop = new Properties();

        try {
            System.out.println("Trying to load config.properties from path:");
            System.out.println(new java.io.File("config.properties").getAbsolutePath());

            FileInputStream fis = new FileInputStream("config.properties");

            prop.load(fis);
            System.out.println("✔ config.properties loaded successfully!");

        } catch (Exception e) {
            System.out.println("❌ ERROR loading config.properties!");
            e.printStackTrace();
        }

        return prop;
    }
}
