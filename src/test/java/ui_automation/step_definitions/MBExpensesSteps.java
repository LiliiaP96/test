package ui_automation.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import ui_automation.pages.MBExpensesPage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;
import ui_automation.utilities.ExcelUtility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MBExpensesSteps {

    MBExpensesPage mbExpensePage = new MBExpensesPage();
    static final Logger log = LogManager.getLogger(MBExpensesSteps.class);

    @Given("user navigates to MealB landing page")
    public void user_navigates_to_MealB_landing_page() {
        log.info("Navigating to the Downloads Page");
        String mbLoginUrl = ConfigurationReader.getProperty("ui-config.properties","mealb.url");
        Driver.getInstance().getDriver().get(mbLoginUrl);
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() throws Exception {
        log.info("Logging in to MealB with valid credentials");
        mbExpensePage.login();
    }

    @Then("user navigates to {string} tab")
    public void user_navigates_to_tab(String tab) {
        log.info("Navigating to " + tab + " Tab");
        switch (tab) {
            case "Dashboard":
                //TODO implement this dashboard case when implemented
                break;
            case "Expenses":
                mbExpensePage.mbExpensesTab.click();
                break;
        }
    }

    @Then("user navigates to {string} expense modal window")
    public void user_navigates_to_expense_modal_window(String expenseType) throws InterruptedException {
        mbExpensePage.navigateToExpenseModal(expenseType);
    }

    @Then("user completes all fields on {string} expense modal window")
    public void user_completes_all_fields_on_expense_modal_window(String expenseType) throws Exception {
        String excelPath = System.getProperty("user.dir") + "/src/test/resources/testData/Keywords.xlsx";
//        FileInputStream ExcelFile = new FileInputStream(excelPath);
//        XSSFWorkbook workBook = new XSSFWorkbook(ExcelFile);
//        XSSFSheet workSheet = workBook.getSheet("Sheet1");

        ExcelUtility.setExcelFile(excelPath, "Sheet1");

//        XSSFCell cell = workSheet.getRow(1).getCell(0);
//        String expenseNameFromExcel = cell.getStringCellValue();
//        mbExpensePage.mealEntModalExpenseNameTextField.sendKeys(expenseNameFromExcel);

        /* Extract data for expense from Excel File */
        String expenseNameFromExcel = ExcelUtility.getCellData(1, 0);
        double amount = ExcelUtility.getCellDataAsDouble(1, 3);
        String businessPurpose = ExcelUtility.getCellData(1, 4);
        String company = ExcelUtility.getCellData(1, 5);
        String projectName = ExcelUtility.getCellData(1, 6);

        /* Fill out the expense modal using extracted data from Excel File */
        mbExpensePage.mealEntModalExpenseNameTextField.sendKeys(expenseNameFromExcel);
        mbExpensePage.amount.sendKeys(String.valueOf(amount));
        mbExpensePage.businessPurpose.sendKeys(businessPurpose);
        mbExpensePage.company.sendKeys(company);
        mbExpensePage.projectName.sendKeys(projectName);
    }

    @Then("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
    }

    @Then("user verifies created {string} expense on expenses table")
    public void user_verifies_created_expense_on_expenses_table(String expenseType) {
    }


}
