
package lapcorpAutomation;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions extends BaseTest {

    HomePage homePage;
    CareersPage careersPage;
    JobDetailsPage jobDetailsPage;

    @Given("I open the labcorp homepage")
    public void i_open_the_labcorp_homepage() {
        setup();
        driver.get("https://www.labcorp.com");
        homePage = new HomePage(driver);
    }

    @When("I click on the Careers link")
    public void i_click_on_the_careers_link() {
        homePage.clickCareers();
        careersPage = new CareersPage(driver);
    }

    @When("I search for the job {string}")
    public void i_search_for_the_job(String jobTitle) {
        careersPage.searchJob(jobTitle);
    }

    @When("I select the job {string}")
    public void i_select_the_job(String jobTitle) {
        careersPage.selectJob(jobTitle);
        jobDetailsPage = new JobDetailsPage(driver);
    }

    @Then("I verify job title is {string}")
    public void i_verify_job_title_is(String expectedTitle) {
        Assert.assertEquals(expectedTitle, jobDetailsPage.getJobTitle());
    }

    @Then("I verify job location is {string}")
    public void i_verify_job_location_is(String expectedLocation) {
        Assert.assertEquals(expectedLocation, jobDetailsPage.getJobLocation());
    }

    @Then("I verify job id is {string}")
    public void i_verify_job_id_is(String expectedId) {
        Assert.assertEquals(expectedId, jobDetailsPage.getJobId());
    }

    @Then("I verify description paragraph {int} is {string}")
    public void i_verify_description_paragraph_is(Integer paraNum, String expectedText) {
        Assert.assertTrue(jobDetailsPage.getDescriptionParagraph(paraNum).contains(expectedText));
    }

    @Then("I verify management support bullet {int} is {string}")
    public void i_verify_management_support_bullet_is(Integer bulletNum, String expectedText) {
        Assert.assertTrue(jobDetailsPage.getManagementSupportBullet(bulletNum).contains(expectedText));
    }

    @Then("I verify requirement {int} is {string}")
    public void i_verify_requirement_is(Integer reqNum, String expectedText) {
        Assert.assertTrue(jobDetailsPage.getRequirement(reqNum).contains(expectedText));
    }

    @Then("I verify suggested automation tool contains {string}")
    public void i_verify_suggested_automation_tool_contains(String expectedText) {
        Assert.assertTrue(jobDetailsPage.getSuggestedAutomationTool().contains(expectedText));
    }

    @When("I click Apply Now")
    public void i_click_apply_now() {
        jobDetailsPage.clickApplyNow();
    }

    @Then("I verify application page details job title {string}, location {string}, job id {string}, extra text {string}")
    public void i_verify_application_page_details(String title, String location, String id, String extraText) {
        Assert.assertEquals(title, jobDetailsPage.getJobTitle());
        Assert.assertEquals(location, jobDetailsPage.getJobLocation());
        Assert.assertEquals(id, jobDetailsPage.getJobId());
        Assert.assertTrue(jobDetailsPage.getDescriptionParagraph(1).contains(extraText));
    }

    @When("I click Return to Job Search")
    public void i_click_return_to_job_search() {
        jobDetailsPage.clickReturnToJobSearch();
        teardown();
    }
}
