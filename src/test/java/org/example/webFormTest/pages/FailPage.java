package org.example.webFormTest.pages;

import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FailPage extends BasePage{

    public FailPage() {
        super();
    }
    @FindBy(css = "#alert_column > .alert li")
    private List<WebElement> alertMessageContent;

    private List<String> getAlertMessageContent() {
        List<String> alertMessages = new ArrayList<String>();

        for(WebElement message : alertMessageContent) {
            alertMessages.add(message.getText());
        }
        System.out.println(alertMessages);
        return alertMessages;
    }
    public void userShouldSeeAgeOutOfRangeAlert(){
        String expectedText = "age out of range";
        assertVerify(expectedText);
    }
    public void userShouldSeeEmptyNameInputAlert(){
        String expectedText = "name is required";
        assertVerify(expectedText);
    }
    private void assertVerify(String expectedText) {
        Assert.assertThat(getAlertMessageContent(), IsCollectionContaining.hasItem(expectedText));
    }
}
