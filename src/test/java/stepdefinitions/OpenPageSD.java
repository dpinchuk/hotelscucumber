package stepdefinitions;

import controllers.MainController;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static configuration.Configuration.DAYS;
import static configuration.Configuration.TEST_CITY;
import static org.junit.Assert.assertEquals;

public class OpenPageSD {

    private MainController mainController;
    private WebElement webElement;

    @Given("^Open main web page$")
    public void openMainWebPage() throws Throwable {
        this.mainController = new MainController();
        this.mainController.initTestEnvironment();
    }

    @And("^Find search field$")
    public void findSearchField() throws Throwable {
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-destination']"));
        this.webElement.clear();
    }

    @And("^Input data into the field$")
    public void inputDataIntoTheField() throws Throwable {
        this.webElement.sendKeys(TEST_CITY);
        this.webElement.sendKeys(Keys.TAB);
    }

    @And("^Press search button$")
    public void pressSearchButton() throws Throwable {
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='main-content']/div/div/div[1]/div/div/div/div[1]/div/form/div[5]/button"));
        this.webElement.click();
    }

    @Then("^Open search page$")
    public void openSearchPage() throws Throwable {
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='search']/div[1]/div/h1"));
        assertEquals(TEST_CITY, this.webElement.getText());
    }
}
