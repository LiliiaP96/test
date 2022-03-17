package ui_automation.step_definitions;

import io.cucumber.java.en.*;
import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ui_automation.utilities.Driver;


public class MyBlue {
WebDriver driver = Driver.getInstance().getDriver();
Actions action = new Actions(driver);
    @Given("user navigates to MyBlue HomePage")
    public void user_navigates_to_MyBlue_HomePage() {
       driver.get("https://www.fepblue.org/health-management-tools/benefits-myblue");
    }

    @When("user hovers over {string} tab")
    public void user_hovers_over_tab(String string) {
        action.moveToElement(driver.findElement(By.xpath("//span[text()='Tools & Resources' and @class='m-nav__link']"))).perform();
    }

    @When("user hovers over AskBlue Finder Tool")
    public void user_hovers_over_AskBlue_Finder_Tool() {
        action.moveToElement(driver.findElement(By.xpath("//span[text()='AskBlue Plan Finder Tools']"))).perform();
    }

    @When("user clicks on {string} plan finder tool")
    public void user_clicks_on_plan_finder_tool(String string) {

    }

    @Then("user is redirected to {string} plan finder tool page")
    public void user_is_redirected_to_plan_finder_tool_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


}
