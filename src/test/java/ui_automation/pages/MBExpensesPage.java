package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class MBExpensesPage {

    WebDriver driver;
    public MBExpensesPage(){
        driver= Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }
s
    @FindBy(name = "usernameOrEmailAddress")
    public WebElement mbUsername;

    @FindBy(name = "Password")
    public WebElement mbPassword;

    @FindBy(id = "LoginButton")
    public WebElement mbLoginButton;

    @FindBy(xpath = "//a[contains(text(),'Expenses')]")
    public WebElement mbExpensesTab;

    //TODO enhance this locator
    @FindBy(xpath = "(//*[contains(@class,'add-expense-button')])[2]")
    public WebElement mbExpensesDropdown;

    //TODO enhance this locator
    @FindBy(xpath = "(//*[text()='Meal & Entertainment'])[4]")
    public WebElement mbExpensesMealEntOption;

    @FindBy(id = "name")
    public WebElement mealEntModalExpenseNameTextField;

    @FindBy (id = "Amount")
    public WebElement amount;

    @FindBy (xpath = "//div[@class='btn-group bootstrap-select form-control']//span[@class='filter-option pull-left']")
    public WebElement expenseRelationship;

    @FindBy (id = "BusinessPurpose")
    public WebElement businessPurpose;

    @FindBy (id = "Company")
    public WebElement company;

    @FindBy (id = "ProjectName")
    public WebElement projectName;

    public void login () throws Exception {
        String username = ConfigurationReader.getProperty("ui-config.properties","mealb.username");
        String password = ConfigurationReader.getProperty("ui-config.properties","mealb.password");
        mbUsername.sendKeys(username);
        mbPassword.sendKeys(password);
        mbLoginButton.click();
        Thread.sleep(3000);
    }

    public void navigateToExpenseModal (String expenseType) throws InterruptedException {
        mbExpensesDropdown.click();

        switch (expenseType) {
            case "Other":
                //TODO implement this expense type case when implemented
                break;
            case "Meal and Entertainment":
                mbExpensesMealEntOption.click();
                break;
            case "Travel":
                //TODO implement this expense type case when implemented
                break;
            case "Gift":
                //TODO implement this expense type case when implemented
                break;
        }
        Thread.sleep(3000);
    }




}
