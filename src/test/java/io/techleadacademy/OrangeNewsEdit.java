package io.techleadacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrangeNewsEdit {
    WebDriver driver;

    @Test
    public void ProjectDay() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait =new WebDriverWait(driver, 10);

        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard");

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        driver.findElement(By.xpath("//a[@class='collapsible-header waves-effect waves-orange']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//li[@class='level2 no-padding parent'][6]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@id='menu_news_viewNewsList']//span[@class='left-menu-title']")).click();

        Thread.sleep(5000);
        driver.switchTo().frame("noncoreIframe");

        Map<String, List<String>> data = new HashMap<>();
        List<WebElement> row = driver.findElements(By.className("dataRaw"));
        for (WebElement element : row) {
            String topic = element.findElement(By.xpath(".//td[2]")).getText();
            List<String> ls = new ArrayList<>();
            ls.add(element.findElement(By.xpath(".//td[3]")).getText());
            ls.add(element.findElement(By.xpath(".//td[6]")).getText());

            if (element.findElement(By.xpath(".//td//i")).getAttribute("class").contains("disabled")){
                ls.add("Attachment - NO");
            } else {
                ls.add("Attachment - YES");
            }
            data.put(topic, ls);
        }
        for (String key: data.keySet()){
            System.out.print(key);
            for(String s : data.get(key)){
                System.out.print(" | " + s);
            }
            System.out.println("\n");
        }

        driver.findElement(By.id("list_item_add")).click();

        WebElement addNews = driver.findElement(By.id("list_item_add"));

        WebElement inputTopic = driver.findElement(By.id("news_topic"));
        Thread.sleep(2000);






    }
}


