package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UserPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.*;

public class UsersTableStepDefs {
    UserPage userPage = new UserPage();

    @When("I search for {string}")
    public void i_search_for(String searchString) {
        BrowserUtils.waitForClickability(userPage.search, 5);
        userPage.search.sendKeys(searchString);
        BrowserUtils.wait(5);

    }

    @Then("table should contain rows with {string}")
    public void table_should_contain_rows_with(String expectedString) {

        int size = userPage.allUserIds.size();
        for (int i = 0; i < size; i++) {
            String id = userPage.allUserIds.get(i).getText().toLowerCase();
            String name = userPage.allFullNames.get(i).getText().toLowerCase();
            String email = userPage.allEmails.get(i).getText().toLowerCase();
            System.out.println("ROW: " + (i + 1));
            System.out.println(id + "\t" + name + "\t" + email);

            boolean found = id.contains(expectedString)
                    || (name.contains(expectedString))
                    || email.contains(expectedString);

            assertTrue("Expected String was not found" +expectedString, found);
        }

    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {
        System.out.println("options = " + expectedColumnNames);
        BrowserUtils.wait(2);
        List<String> columnNameStr = BrowserUtils.getElementsText(userPage.columnNames);
        assertEquals(expectedColumnNames, columnNameStr);

    }

    @Then("table should contain this data")
    public void table_should_contain_this_data(Map<String, String> user) {
        System.out.println(user.entrySet());


        String name = user.get("Full name");
        String email = user.get("Email");
        String id = user.get("User ID");

        System.out.println("email = " + email);
        System.out.println("name = " + name);
        System.out.println("id = " + id);

        //get all rows. verify that at least one
        // of the rows contains all og the user info
        List<WebElement> allRows = userPage.allRoes;
        List<String> allRowsTxt = BrowserUtils.getElementsText(allRows);
        boolean found = true;
        for (String row : allRowsTxt) {
            System.out.println("row = " + row);
            found = row.contains(id) &&
                    row.contains(name) &&
                    row.contains(email);
            if(found){
                break;
            }
        }
        assertTrue(user+" was not found", found);
    }


}
