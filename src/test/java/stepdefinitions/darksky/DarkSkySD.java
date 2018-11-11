package stepdefinitions.darksky;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static stepdefinitions.MainSD.mainController;

public class DarkSkySD {

    private WebElement webElement;

    @And("^Verify current temperature is between low and high value$")
    public boolean verifyCurrentTemperatureIsBetweenLowAndHighValue(DataTable table) throws Throwable {
        Thread.sleep(1000);
        List<List<String>> data = table.raw();

        String str = "";

        this.webElement = mainController.getDriver().findElement(By.xpath(data.get(1).get(0)));
        str = this.webElement.getText().split(" ")[0].substring(0, this.webElement.getText().split(" ")[0].length() - 1);
        int currentValue = Integer.parseInt(str);

        this.webElement = mainController.getDriver().findElement(By.xpath(data.get(1).get(1)));
        str = this.webElement.getText().split(" ")[1].substring(0, this.webElement.getText().split(" ")[1].length() - 1);
        int lowValue = Integer.parseInt(str);

        this.webElement = mainController.getDriver().findElement(By.xpath(data.get(1).get(2)));
        str = this.webElement.getText().split(" ")[1].substring(0, this.webElement.getText().split(" ")[1].length() - 1);
        int highValue = Integer.parseInt(str);

        if (currentValue >= lowValue && currentValue <= highValue) {
            return true;
        }
        System.out.println(currentValue);
        return false;
    }
}
