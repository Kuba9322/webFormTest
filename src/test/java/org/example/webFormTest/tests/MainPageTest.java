package org.example.webFormTest.tests;

import org.example.webFormTest.pages.FormPage;
import org.junit.jupiter.api.Test;

public class MainPageTest {

    //Examples of test

    @Test
    public void fillInValidDate(){
        new FormPage()
                .submitFormWithValidData()
                .formShouldSuccesfullyComitted();
    }

    @Test void ageBelowTheUpperLimitTest(){
        new FormPage()
                .submitFormWithAgeBelowTheUpperLimit()
                .userShouldSeeAgeOutOfRangeAlert();
    }
    @Test void ageAboveTheUpperLimitTest(){
        new FormPage()
                .submitFormWithAgeAboveTheUpperLimit()
                .userShouldSeeAgeOutOfRangeAlert();
    }
    @Test
    public void voidNameInputs() {
        new FormPage()
                .submitFormWithVoidNameInputs()
                .userShouldSeeEmptyNameInputAlert();
    }
    @Test
    public void voidSurnameInputs() {
        new FormPage()
                .submitFormWithVoidSurnameInputs()
                .userShouldSeeEmptyNameInputAlert();
    }
}