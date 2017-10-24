package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class GeoPage extends AbstractPage {
    private final static String URL = "https://yandex.ua/tune/geo/?retpath=https%3A%2F%2Fyandex.ua%2F%3Fdomredir%3D1&nosync=1";

    @FindBy(id = "city__front-input")
    private WebElement cityInput;

    @FindBy(id = "cbid587806706158")
    private WebElement autoDetectCheckbox;

    @FindBys(@FindBy(xpath = ".//ul[contains(@class,popup__items)]/li"))
    private List<WebElement> variantsOfCity;

    @FindBy(xpath = ".//button[contains(@class,'form__save')]")
    private WebElement saveButton;

    @FindBy(xpath = ".//a[contains(@class,'form__back')]")
    private WebElement backButton;

    public GeoPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return URL;
    }

    public void setCityInput(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
        cityInput.click();
    }

    public void clickOnAutoDetectCheckbox() {
        autoDetectCheckbox.click();
    }

    public boolean isSelectAutoDetectCheckbox() {
        return autoDetectCheckbox.isSelected();
    }

    public void clickOnSaveButton() {
        if (saveButton.isEnabled()) {
            saveButton.click();
        } else {
            backButton.click();
        }
    }

    public void clickOnVariantOfCity(int index) {
        if (variantsOfCity.size() > 0 && variantsOfCity.get(index - 1).isDisplayed()) {
            variantsOfCity.get(index - 1).click();
        }
    }
}
