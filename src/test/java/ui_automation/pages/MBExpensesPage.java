package ui_automation.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

import java.util.List;

public class MBExpensesPage {
    static final Logger log = LogManager.getLogger(MBExpensesPage.class);
    WebDriver driver;
    public MBExpensesPage(){
        driver= Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

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

    @FindBy (id = "ExpenseDateTime")
    public WebElement dateField;

    @FindBy (xpath = "//*[contains(@class,'save-button')]")
    public WebElement saveButton;

    @FindBy (id = "expenses-table")
    public WebElement expenseTable;

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

    public void completeMealEntExpenseModal (String date, String expenseNameFromExcel, double amountFromExcel,
                                             String businessPurposeFromExcel, String companyFromExcel, String projectNameFromExcel) throws InterruptedException {
        dateField.click();
        Thread.sleep(1000);
        Driver.getInstance().getDriver().findElement(By.xpath("(//*[@aria-label='"+date+"'])[3]")).click();
        mealEntModalExpenseNameTextField.sendKeys(expenseNameFromExcel);
        amount.sendKeys(String.valueOf(amountFromExcel));
        businessPurpose.sendKeys(businessPurposeFromExcel);
        company.sendKeys(companyFromExcel);
        projectName.sendKeys(projectNameFromExcel);
    }

    public void verifyNewExpense (String expenseNameFromExcel) {
//        List<WebElement> expenseNames = Driver.getInstance().getDriver().findElements
//                (By.xpath("//table[@id='expenses-table']/tbody/tr/td[2]"));
        List<WebElement> expenseNamesLocators = expenseTable.findElements(By.xpath("/tbody/tr/td[2]"));

        for (WebElement expenseNameLocator : expenseNamesLocators) {
            String expenseNameFromUI = expenseNameLocator.getText();

            if (expenseNameFromUI.equals(expenseNameFromExcel)) {
                log.info("New expense was successfully displayed on the Expenses Table");
                break;
            }
        }
    }

    public void deleteExistingRecord (String expenseNameFromExcel) throws Exception {
//        List<WebElement> expenseNamesLocators = expenseTable.findElements(By.xpath("/tbody/tr/td[2]"));
        List<WebElement> expenseNamesLocators = Driver.getInstance().getDriver().findElements(
                By.xpath("//*[@id='expenses-table']/tbody/tr/td[2]"));

        int row = 1;

        for (WebElement expenseNameLocator : expenseNamesLocators) {
            String expenseNameFromUI = expenseNameLocator.getText();

            if (expenseNameFromUI.equals(expenseNameFromExcel)) {
                Thread.sleep(2000);
                Driver.getInstance().getDriver().findElement(By.xpath
                        ("(//*[starts-with(@id,'checkbox')])["+row+"]")).click();
                Thread.sleep(2000);
            }

            row++;
        }
        Thread.sleep(3000);
        Driver.getInstance().getDriver().findElement(By.xpath("//*[contains(@class,'delete-selected-expenses')]")).click();
        handleModalWindow();
    }

    public void handleModalWindow () throws Exception {
        //TODO parametrize this method with modal type and action you want to perform
        //TODO verify modal icon. Note: you can use getAttribute() method
        //TODO verify confirmation messages
        //TODO verify list of buttons available for that modal window
        Thread.sleep(3000);
        Driver.getInstance().getDriver().findElement(By.xpath("//button[@class='confirm']")).click();
        Thread.sleep(3000);
    }

}
