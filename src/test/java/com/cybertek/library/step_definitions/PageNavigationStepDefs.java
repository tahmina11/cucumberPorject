package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashBoardPage;
import com.cybertek.library.pages.UserPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import com.cybertek.library.utilities.LibraryContstants;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageNavigationStepDefs {
    DashBoardPage dashBoardPage = new DashBoardPage();
    UserPage userPage = new UserPage();

    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        switch (link.toLowerCase()) {
            case "dashboard":
                dashBoardPage.dashboard.click();
                break;
            case "users":
                dashBoardPage.users.click();
                break;
            case "books":
                dashBoardPage.books.click();
                break;
        }
    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String page) {
        BrowserUtils.wait(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith(page.toLowerCase()));
        BrowserUtils.wait(2);
        switch (page.toLowerCase()) {
            case "users":
                String actual = dashBoardPage.pageHeader.getText();
                Assert.assertEquals("User Management", actual);
                break;
            case "books":
                actual = dashBoardPage.pageHeader.getText();
                Assert.assertEquals("Book Management", actual);
                break;
        }

    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer selected) {
        System.out.println("selected = " + selected);

        String actual = userPage.getShowRecords().getFirstSelectedOption().getText();
        Assert.assertEquals(selected + "", actual);
    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        System.out.println("options.size() = " + options.size());
        System.out.println("options = " + options);
        List<WebElement> webElements = userPage.getShowRecords().getOptions();
        List<String> allOptions = BrowserUtils.getElementsText(webElements);
        Assert.assertEquals(options, allOptions);
    }

    @When("I select Show {int} records")
    public void i_select_Show_records(Integer option) {

        userPage.getShowRecords().selectByVisibleText(option.toString());
    }

    @Then("the users table must display {int} records")
    public void the_users_table_must_display_records(int expectedCount) {
        BrowserUtils.wait(2);
        int actual = userPage.allRoes.size();
        Assert.assertEquals(expectedCount, actual);
    }

    @When("I go/navigate to {string} page")
    public void i_go_to_page(String page) {
        System.out.println("Going to page: " + page);
        switch (page.toLowerCase()) {
            case LibraryContstants
                    .DASHBOARD:
                dashBoardPage.dashboard.click();
                break;
            case LibraryContstants.USERS:
                dashBoardPage.users.click();
                break;
            case LibraryContstants.BOOKS:
                dashBoardPage.books.click();
                break;
        }
    }



}