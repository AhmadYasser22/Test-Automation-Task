import Pages.HomePage;
import Pages.ResultsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class webAutomationTest {
    private WebDriver driver;

    @BeforeClass
    public void initWebDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void testScenario() {
        HomePage homePage = new HomePage(driver);
        homePage.loadPage();
        homePage.validateHomePageLanding();
        homePage.search("mazda mx-5");

        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.validateResultsObtained();
        resultsPage.printObtainedResultsNumber();
        resultsPage.applyFilter();
        resultsPage.printObtainedResultsNumber();
    }

    @AfterClass
    public void quitWebDriver() {
        driver.quit();
    }
}

