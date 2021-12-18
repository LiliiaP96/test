package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class PracticePage {
    WebDriver driver;

   public  PracticePage (){
       this.driver= Driver.getInstance().getDriver();
       PageFactory.initElements(driver, this);
   }

   @FindBy(xpath="//div[@style='text-align: center;']//a")
    public WebElement downloadBottom;

}
