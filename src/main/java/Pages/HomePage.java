package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {
    public final static By homeButton   =  By.cssSelector("span:contains('Home')");
    public final static By searchInput  =  By.xpath("//input[@id='gh-ac']");
    public final static By searchButton =  By.xpath("//input[@id='gh-btn']");
    public final static By ebayLogo   =    By.id("gh-logo");

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        getDriver().get("https://www.ebay.com/");
    }

    public void validateHomePageLanding() {
        boolean isElementDisplayed = isElementDisplayed(driver, ebayLogo);
        if (isElementDisplayed) {
            System.out.println("Main Page loaded successfully.");
        } else {
            System.out.println("Main Page did not load properly.");
        };
    }



    public void search(String phrase) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        getDriver().findElement(searchInput).sendKeys(phrase);
        getDriver().findElement(searchButton).click();
    }
}
