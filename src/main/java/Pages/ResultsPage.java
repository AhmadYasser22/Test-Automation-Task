package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultsPage extends AbstractPage {
    public WebDriver driver ;
    public final static By resultsCount =  By.className("srp-controls__count-heading");
    public final static By manualButton =  By.xpath("//a[@href='https://www.ebay.com/sch/i.html?_from=R40&_nkw=mazda+mx-5&_sacat=0&Transmission=Manual&_dcat=6324']");

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public void validateResultsObtained() {
        boolean isElementDisplayed = isElementDisplayed(driver, resultsCount);
        if (isElementDisplayed) {
            System.out.println("Results obtained successfully.");
        } else {
            System.out.println("Failed to obtain results.");
        }
    }

    public void printObtainedResultsNumber() {
        String countText = getDriver().findElement(By.className("srp-controls__count-heading")).getText();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(countText);
        if (matcher.find()) {
            int searchCount = Integer.parseInt(matcher.group());
            System.out.println("Search results obtained: " + searchCount);
        } else {
            System.out.println("Failed to obtain search results.");
        }
    }

    public void applyFilter() {
        boolean isElementDisplayed = isElementDisplayed(driver, manualButton);
        if (isElementDisplayed) {
            getDriver().findElement(manualButton).click();
            System.out.println("Filter applied successfully.");
        } else {
            System.out.println("Filter not found.");
        }
    }
}
