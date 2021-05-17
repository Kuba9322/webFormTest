package org.example.webFormTest.utility;

import io.qameta.allure.Attachment;
import org.example.webFormTest.config.WebDriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {

    @Attachment(value="Screenshot", type="image/png")
    public static byte[] captureScreenshot() {
        return ((TakesScreenshot) WebDriverSingleton.getInstance()).getScreenshotAs(OutputType.BYTES);
    }
}
