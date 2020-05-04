package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pojos.Book;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.*;

public class BooksTableStepDefinitions {
    BooksPage booksPage = new BooksPage();

    @Then("books table should contain results matching {}")
    public void books_table_should_contain_results_matching(String book) {
        List<String> actualRows = BrowserUtils.getElementsText(booksPage.allRoes);

        boolean found = true;
        for (String row : actualRows) {
            if (!row.contains(book)) {
                found = false;
            }
        }
        assertTrue(book + " was not found in books table", found);

    }

    @When("I edit book {}")
    public void i_edit_book_The_kiterunner(String book) {
        System.out.println("book = " + book);
        //booksPage.search.sendKeys(book);
        BrowserUtils.waitForClickability(booksPage.search, 5).sendKeys(book);
        //using browse utils for waits
        BrowserUtils.waitForClickability(booksPage.editBook(book), 5).click();

    }

    // register a data table type that uses a custom class
    @DataTableType
    public Book convertBook(Map<String, String> dataTable){
        Book book = new Book(dataTable.get("name"),
                dataTable.get("author"),
                dataTable.get("year"));
        return book;
    }

    @Then("I verify book information")
    public void i_verify_book_information(Book book) {
        System.out.println(book);
        System.out.println("book.getName() = " + book.getName());
        System.out.println("book.getAuthor() = " + book.getAuthor());
        System.out.println("book.getYear() = " + book.getYear());

        assertEquals("Book name did not match",
                book.getName(), booksPage.bookName.getAttribute("value"));
        assertEquals("Book author did not match",
                book.getAuthor(),booksPage.author.getAttribute("value"));
        assertEquals("Book year did not match",
                book.getYear(), booksPage.year.getAttribute("value"));
    }


}