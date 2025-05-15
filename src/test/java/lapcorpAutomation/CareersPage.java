
package lapcorpAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage {
    WebDriver driver;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchJob(String jobTitle) {
        driver.findElement(By.id("keyword")).sendKeys(jobTitle);
        driver.findElement(By.id("searchJobs")).click();
    }

    public void selectJob(String jobTitle) {
        driver.findElement(By.linkText(jobTitle)).click();
    }
}
