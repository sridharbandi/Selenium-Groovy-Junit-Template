package com.tech.selenium.driverutil

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.opera.OperaDriver

import java.util.concurrent.TimeUnit

class DriverFactory {

    def static getDriver() {

        def _driver
        def _browserName = System.getProperty("browser", DriverType.CHROME.toString()).toUpperCase()
        def _driverType = DriverType.valueOf(_browserName)

        switch (_driverType) {
            case DriverType.CHROME:
                WebDriverManager.chromedriver().setup()
                _driver = new ChromeDriver()
                break
            case DriverType.FIREFOX:
                WebDriverManager.firefoxdriver().setup()
                _driver = new FirefoxDriver()
                break
            case DriverType.EDGE:
                WebDriverManager.edgedriver().setup()
                _driver = new EdgeDriver()
                break
            case DriverType.IE:
                WebDriverManager.iedriver().setup()
                _driver = new InternetExplorerDriver()
                break
            case DriverType.OPERA:
                WebDriverManager.operadriver().setup()
                _driver = new OperaDriver()
                break
            default:
                WebDriverManager.chromedriver().setup()
                _driver = new ChromeDriver()
                break
        }
        _driver.manage().window().maximize()
        _driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
        return _driver
    }

}


