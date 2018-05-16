package com.tech.selenium.tests

import com.tech.selenium.driverutil.DriverFactory
import com.tech.selenium.pageobjects.GoogleSearchPage
import com.tech.selenium.pageobjects.SearchResultsPage
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.WebDriver

class RunTest{

    WebDriver browser
    GoogleSearchPage googleSearchPage
    SearchResultsPage searchResultsPage

    @Before
    void setUp() {
        browser = DriverFactory.driver
        googleSearchPage = new GoogleSearchPage(browser)
        searchResultsPage = new SearchResultsPage(browser)
    }

    @Test
    void GoogleSearchPage() {
        googleSearchPage.openURL()
        googleSearchPage.searchFor("Selenium")
        searchResultsPage.assertSeleniumPresent()
    }

    @After
    void tearDown() {
        browser.quit()
    }

}
