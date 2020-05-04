$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/BooksTable.feature");
formatter.feature({
  "name": "books table",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@books"
    },
    {
      "name": "@smoke"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@lib-2453"
    }
  ]
});
formatter.scenario({
  "name": "Verify book information",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@books"
    },
    {
      "name": "@smoke"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@lib-2453"
    },
    {
      "name": "@wip"
    },
    {
      "name": "@librarian"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.cybertek.library.step_definitions.LoginStepDefs.i_am_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I login to application as a librarian",
  "keyword": "And "
});
formatter.match({
  "location": "com.cybertek.library.step_definitions.LoginStepDefs.i_login_to_application_as_a(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to \"Books\" page",
  "keyword": "And "
});
formatter.match({
  "location": "com.cybertek.library.step_definitions.PageNavigationStepDefs.i_go_to_page(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I edit book The kite runner",
  "keyword": "When "
});
formatter.match({
  "location": "com.cybertek.library.step_definitions.BooksTableStepDefinitions.i_edit_book_The_kiterunner(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify book information",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.cybertek.library.step_definitions.BooksTableStepDefinitions.i_verify_book_information(com.cybertek.library.pojos.Book)"
});
formatter.result({
  "status": "passed"
});
formatter.write("Complete scenario: Verify book information");
formatter.after({
  "status": "passed"
});
});