package ui_automation.step_definitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

public class ResumeUploadStep {
WebDriver driver= Driver.getInstance().getDriver();
    @Given("user navigates to {string} home page")
    public void user_navigates_to_home_page(String web) {
       driver.get(ConfigurationReader.getProperty("ui-config.properties","linkedin.url"));
    }

    @When("user clicks on {string} button at {string} profile page")
    public void user_clicks_on_button_at_profile_page(String button, String page) {
        driver.findElement(By.cssSelector("#pv2_overflow_actions_ember386")).click();

    }

    @When("user selects {string} option")
    public void user_selects_option(String string) {
       driver.findElement(By.id("ember501")).click();
    }

    @Then("user successfully uploads the resume")
    public void user_successfully_uploads_the_resume() {
       WebElement el = driver.findElement(By.linkText("Upload resume"));
       el.click();
       el.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\upload\\Lilia Petryshyn - Resume.pdf");
    }

}
