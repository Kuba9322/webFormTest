package org.example.webFormTest.pages;

import org.example.webFormTest.config.WebDriverSingleton;
import org.example.webFormTest.utility.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {


    public BasePage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
        Actions.waitForVisibilityOfElement(pageContent);
    }

    @FindBy(id = "columns")
    private WebElement pageContent;
}

