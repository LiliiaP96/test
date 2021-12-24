package ui_automation.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_automation.pages.PracticePage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

public class PracticeSteps {
    PracticePage  practicePage = new PracticePage();
static final Logger oLog = LogManager.getLogger(PracticeSteps.class);

    @Given("user navigates to download page")
    public void user_navigates_to_download_page() {
        oLog.info("Navigating to the Downloads Page");
        Driver.getInstance().getDriver().get(ConfigurationReader.getProperty("ui-config.properties", "download.url"));
    }

    @Then("user successfully downloads the file")
    public void user_successfully_downloads_the_file() {
        oLog.info("Clicking on Downloads button");

       practicePage.downloadBottom.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        oLog.info("Successfully Clicked on Downloads Button");


    }

}
