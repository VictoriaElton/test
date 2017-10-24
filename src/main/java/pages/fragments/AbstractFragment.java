package pages.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractFragment {
    protected WebDriver driver;

    public AbstractFragment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
