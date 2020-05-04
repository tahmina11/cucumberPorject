package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UserPage extends PageBase {
    @FindBy(name = "tbl_users_length")
    public WebElement showRecords;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRoes;

    @FindBy(tagName = "input")
    public WebElement search;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> allUserIds;

    @FindBy(xpath = "//table/tbody/tr/td[3]")
    public List<WebElement> allFullNames;

    @FindBy(xpath = "//table/tbody/tr/td[4]")
    public List<WebElement> allEmails;

    @FindBy(tagName = "//th")
    public List<WebElement> columnNames;

    @FindBy(css ="a.btn-lg")
    public WebElement addUser;

    @FindBy(name ="full_name")
    public WebElement fullName;

    @FindBy(name ="email")
    public WebElement email;

    @FindBy(id ="address")
    public WebElement address;

    @FindBy(name = "password")
    public WebElement password;



    public Select getShowRecords() {
        return new Select(showRecords);
    }


}
