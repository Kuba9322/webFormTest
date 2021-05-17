package org.example.webFormTest.config;

import org.example.webFormTest.utility.Screenshot;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestConfig {

    private WebDriver driver;

    @Before
    public void setUp() {
        String baseUrl = "https://www.smart4aviation.aero/career-tasks/software-tester";
        driver = WebDriverSingleton.getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @After
    public void tearDown() {
        Screenshot.captureScreenshot();
        WebDriverSingleton.quit();
    }
}
