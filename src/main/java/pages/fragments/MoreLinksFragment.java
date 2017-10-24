package pages.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class MoreLinksFragment extends AbstractFragment {

    @FindBys(@FindBy(xpath = ".//div[contains(@class, 'home-tabs__more-item')]"))
    private List<WebElement> links;

    public MoreLinksFragment(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getLinks() {
        return links;
    }

    public WebElement getLink(int indexOfLink) {
        return links.get(indexOfLink);
    }

    public ArrayList<String> getHeaderOfLinks() {
        ArrayList<String> result = new ArrayList<String>();

        for (WebElement link : links) {
            result.add(link.getText());
        }

        return result;
    }
}
