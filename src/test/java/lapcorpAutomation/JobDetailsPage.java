
package lapcorpAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobDetailsPage {
    WebDriver driver;

    public JobDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getJobTitle() {
        return driver.findElement(By.cssSelector("h1.job-title")).getText();
    }

    public String getJobLocation() {
        return driver.findElement(By.cssSelector("span.job-location")).getText();
    }

    public String getJobId() {
        return driver.findElement(By.cssSelector("span.job-id")).getText();
    }

    public String getDescriptionParagraph(int paragraphNumber) {
        return driver.findElement(By.xpath("(//div[@class='description']//p)[" + paragraphNumber + "]")).getText();
    }

    public String getManagementSupportBullet(int bulletNumber) {
        return driver.findElement(By.xpath("(//ul[@class='management-support']//li)[" + bulletNumber + "]")).getText();
    }

    public String getRequirement(int reqNumber) {
        return driver.findElement(By.xpath("(//ul[@class='requirements']//li)[" + reqNumber + "]")).getText();
    }

    public String getSuggestedAutomationTool() {
        return driver.findElement(By.cssSelector("div.suggested-tools")).getText();
    }

    public void clickApplyNow() {
        driver.findElement(By.linkText("Apply Now")).click();
    }

    public void clickReturnToJobSearch() {
        driver.findElement(By.linkText("Return to Job Search")).click();
    }
}
