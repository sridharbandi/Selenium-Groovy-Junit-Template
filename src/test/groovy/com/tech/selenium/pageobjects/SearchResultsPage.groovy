package com.tech.selenium.pageobjects

import org.junit.Assert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SearchResultsPage {

    WebDriver _driver

    @FindBy(linkText = "Selenium - Web Browser Automation")
    WebElement _lnkSelenium

    SearchResultsPage(driver) {
        this._driver = driver
        PageFactory.initElements(_driver, this)
    }

    def assertSeleniumPresent(){
        Assert.assertTrue(_lnkSelenium.isDisplayed())
    }
}
