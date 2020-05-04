package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashBoardPage;
import io.cucumber.java.en.Then;

import static junit.framework.TestCase.*;

public class DashBoardStepDefs {
    DashBoardPage dashBoardPage = new DashBoardPage();


    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedName) {
        String actualName = dashBoardPage.accountHolderName.getText();
        // # --> means id is css
        //#navbarDropdown --> element that has id navbarDropdown
    assertEquals("Account holder name did not match", expectedName, actualName);
    }

}
