package stepdefinitions.hotels;

import controllers.MainController;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static configuration.Configuration.DATE_FORMAT;
import static configuration.Configuration.DAYS;
import static configuration.Configuration.TEST_CITY;
import static org.junit.Assert.assertEquals;

public class HotelsSD {

    private MainController mainController;
    private WebElement webElement;
//
//    @Given("^Opened main web page$")
//    public void openMainWebPage(DataTable table) throws Throwable {
//        List<List<String>> data = table.raw();
//        this.mainController = new MainController(data.get(1).get(0));
//        this.mainController.initTestEnvironment();
//    }

    @And("^Find search field$")
    public void findSearchField() throws Throwable {
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-destination']"));
        this.webElement.clear();
    }

    @And("^Input data into the city field$")
    public void inputDataIntoTheField(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        String dataRaw = data.get(1).get(0);
        this.webElement.sendKeys(dataRaw);
        this.webElement.sendKeys(Keys.TAB);
    }

    @And("^Press search button$")
    public void pressSearchButton() throws Throwable {
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='main-content']/div/div/div[1]/div/div/div/div[1]/div/form/div[5]/button"));
        this.webElement.click();
    }

    @And("^Input check in date tomorrow$")
    public void inputCheckInDate() throws Throwable {
        Calendar calendar = new GregorianCalendar();
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        String date = dateFormat.format(calendar.getTime());
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-localised-check-in']"));
        this.webElement.clear();
        this.webElement.sendKeys(date);
        //this.webElement.sendKeys(Keys.TAB);
    }

    @And("^Point count of check out days$")
    public void pointCountOfCheckOutDays(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        String dataRaw = data.get(1).get(0);
        int days = Integer.parseInt(dataRaw);
        Calendar calendar = new GregorianCalendar();
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        calendar.add(Calendar.DAY_OF_YEAR, days + 1);
        String date = dateFormat.format(calendar.getTime());
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-localised-check-out']"));
        this.webElement.clear();
        this.webElement.sendKeys(date);
        this.webElement.sendKeys(Keys.TAB);
    }

    @And("^Click on Edit or add rooms button$")
    public void clickOnEditOrAddRoomsButton() throws Throwable {
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='main-content']/div/div/div[1]/div/div/div/div[1]/div/form/div[4]/button"));
        this.webElement.click();
    }

    @And("^Click on Rooms list and select More options$")
    public void clickOnRoomsListAndSelectMoreOptions() throws Throwable {
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-compact-occupancy']"));
        this.webElement.click();
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-compact-occupancy']/option[3]"));
        this.webElement.click();
    }

    @And("^Select count of Rooms$")
    public void selectCountOfRooms(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        int rooms = Integer.parseInt(data.get(1).get(0));
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-rooms']"));
        this.webElement.click();
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-rooms']/option[" + rooms + "]"));
        this.webElement.click();
        //this.webElement.sendKeys(Keys.TAB);

    }

    @And("^Select count of Adults$")
    public void selectCountOfAdults(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        String adults = data.get(1).get(0);
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-adults']"));
        this.webElement.click();
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-adults']/option[" + adults + "]"));
        this.webElement.click();
    }

    @And("^Select number of Children$")
    public void selectNumberSOfChildren(DataTable table) throws Throwable {//*[@id="qf-0q-room-0-children"]/option[3]
        List<List<String>> data = table.raw();
        int children = Integer.parseInt(data.get(1).get(0));
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id=\"qf-0q-room-0-children\"]"));
        this.webElement.click();
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id=\"qf-0q-room-0-children\"]/option[" + (children + 1) + "]"));
        this.webElement.click();
    }

    @And("^Select age of Children$")
    public void selectAgeSOfChildren(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        int childAge1 = Integer.parseInt(data.get(1).get(0));
        int childAge2 = Integer.parseInt(data.get(1).get(1));

        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-child-0-age']"));
        this.webElement.click();
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-child-0-age']/option[" + (childAge1 + 2) + "]"));
        this.webElement.click();

        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-child-1-age']"));
        this.webElement.click();
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='qf-0q-room-0-child-1-age']/option[" + (childAge2 + 2) + "]"));
        this.webElement.click();
    }

    @Then("^Opened search page$")
    public void openSearchPage() throws Throwable {
        this.webElement = this.mainController.getDriver().findElement(By.xpath("//*[@id='search']/div[1]/div/h1"));
        assertEquals(TEST_CITY, this.webElement.getText());
    }

}