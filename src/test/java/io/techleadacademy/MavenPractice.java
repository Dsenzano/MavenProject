package io.techleadacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenPractice {
    public static void main(String[] args) {
        TestData test = new TestData();
        System.out.println(test.firstNames());
        System.out.println(test.lastNames());
        System.out.println(test.phoneNumber());
        System.out.println(test.address());
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://google.com");

    }
}
