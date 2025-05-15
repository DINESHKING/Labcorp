
package lapcorpAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    By careersLink = By.linkText("Careers");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCareers() {
        driver.findElement(careersLink).click();
    }
}
