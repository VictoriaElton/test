package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.fragments.MoreLinksFragment;

public class MainPage extends AbstractPage {
    private final static String URL = "https://yandex.ua/";

    @FindBy(xpath = ".//a[contains(@class,'geolink')]")
    private WebElement geoLink;

    @FindBy(xpath = ".//a[contains(@class, 'home-link') and text()='ещё']")
    private WebElement showMoreHomeLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return URL;
    }

    public void clickOnGeoLink() {
        geoLink.click();
    }

    public void clickOnShowMoreHomeLink() {
        showMoreHomeLink.click();
    }

    public MoreLinksFragment getMoreLinksFragment() {
        return new MoreLinksFragment(driver);
    }
}
