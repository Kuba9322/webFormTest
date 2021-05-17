package org.example.webFormTest.pages;

import io.qameta.allure.Step;
import org.example.webFormTest.utility.DataFaker;
import org.example.webFormTest.utility.Screenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Random;

public class FormPage extends BasePage {

    private DataFaker faker = new DataFaker();
    private Random random = new Random();
    private final int MIN_AGE = 0;
    private final int MAX_AGE = 100;

    public FormPage() {
        super();
    }

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "surname")
    private WebElement surname;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "age")
    private WebElement age;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "comment")
    private WebElement comment;

    public void fillInValidName() {
        name.sendKeys(faker.getFakeFirstname());
    }

    public void fillInValidSurname() {
        surname.sendKeys(faker.getFakeLastname());
    }

    public void fillInValidEmail() {
        email.sendKeys(faker.getFakeEmail());
    }

    public void fillInValidAge(int min, int max) {
        age.sendKeys(Integer.toString(random.nextInt((max - min) + 1) + min));
    }

    public void fillInValidPhone() {
        phone.sendKeys(faker.getFakeMobilePhone());
    }

    public void fillInValidComment() {
        comment.sendKeys(faker.getFakeComment());
    }

    @FindBy(id = "submit")
    private WebElement submit;

    private void fillInForm() {
        fillInValidName();
        fillInValidSurname();
        fillInValidEmail();
        fillInValidAge(MIN_AGE, MAX_AGE);
        fillInValidPhone();
        fillInValidComment();
    }

    @Step
    public SuccessPage submitFormWithValidData() {
        fillInForm();
        Screenshot.captureScreenshot();
        submit.click();
        return new SuccessPage();
    }
    @Step
    public FailPage submitFormWithAgeBelowTheUpperLimit() {
        fillInForm();
        age.sendKeys(Integer.toString(MIN_AGE-1));
        return getFailPage();
    }
    @Step
    public FailPage submitFormWithAgeAboveTheUpperLimit(){
        fillInForm();
        age.sendKeys(Integer.toString(MAX_AGE+1));
        return getFailPage();
    }
    @Step
    public FailPage submitFormWithVoidNameInputs(){
        fillInForm();
        name.sendKeys("");
        return getFailPage();
    }
    @Step
    public FailPage submitFormWithVoidSurnameInputs(){
        fillInForm();
        surname.sendKeys("");
        return getFailPage();
    }
    private FailPage getFailPage() {
        Screenshot.captureScreenshot();
        submit.click();
        return new FailPage();
    }


}
