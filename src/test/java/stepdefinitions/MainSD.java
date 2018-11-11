package stepdefinitions;

import controllers.MainController;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainSD {

    public static MainController mainController;
    private WebElement webElement;

    @Given("^Goto$")
    public void openMainWebPage(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        mainController = new MainController(data.get(1).get(0));
        mainController.initTestEnvironment();
    }

    @And("^Clear search text field$")
    public void findAndClearField(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        this.webElement = mainController.getDriver().findElement(By.xpath(data.get(1).get(0)));
        this.webElement.clear();
    }

    @And("^Enter address or zipcode into the search field$")
    public void inputDataInTheField(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        this.webElement = mainController.getDriver().findElement(By.xpath(data.get(1).get(0)));
        this.webElement.clear();
        this.webElement.sendKeys(data.get(1).get(1));
    }

    @And("^Click on search magnifying glass$")
    public void findAndClickSearhButton(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        this.webElement = mainController.getDriver().findElement(By.xpath(data.get(1).get(0)));
        this.webElement.click();
    }
}