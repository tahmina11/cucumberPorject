package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static junit.framework.TestCase.*;

public class AddUsersStepDefs {
    UserPage userPage = new UserPage();

    @When("I click on Add Users")
    public void i_click_on_Add_Users() {
        userPage.addUser.click();
    }

    @Then("dialog fields must have matching placeholder")
    public void dialog_fields_must_have_matching_placeholder(Map<String, String> fields) {
        for (String key : fields.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value = " + fields.get(key));
            System.out.println();
        }
        //  System.out.println(fields.entrySet());
        String expectedFullName = fields.get("fullname");
        String actualName = userPage.fullName.getAttribute("placeholder");
        assertEquals(expectedFullName, actualName);

        String expectedEmail = fields.get("email");
        String actualEmail = userPage.email.getAttribute("placeholder");
        assertEquals(expectedEmail, actualEmail);

        String expectedPassword = fields.get("password");
        String actualPassword = userPage.password.getAttribute("placeholder");
        assertEquals("oh it failed", expectedPassword, actualPassword);

        String expectedAddress = fields.get("address");
        String actualAddress = userPage.address.getAttribute("placeholder");
        assertEquals("Address placeholder must be empty",
                "", actualAddress);
        String myString;
        String yourString="";


    }

}
