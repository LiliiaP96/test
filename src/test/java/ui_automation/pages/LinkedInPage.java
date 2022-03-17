package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class LinkedInPage {

    WebDriver driver;
    public LinkedInPage(){
        driver= Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }




}
