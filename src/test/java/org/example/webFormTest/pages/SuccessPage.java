package org.example.webFormTest.pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends BasePage{

    public SuccessPage() {
        super();
    }
    @FindBy(id = "success")
    private WebElement success;

    public void formShouldSuccesfullyComitted(){
        String confirmation = success.getText();
        String expectedText = "SUCCESS";
        Assert.assertThat(confirmation, IsEqual.equalTo(expectedText));
    }
}
