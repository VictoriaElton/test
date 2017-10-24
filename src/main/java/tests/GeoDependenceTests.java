package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GeoPage;
import pages.MainPage;

import java.util.ArrayList;

public class GeoDependenceTests extends AbstractTest {
    private MainPage mainPage;
    private GeoPage geoPage;

    @BeforeTest
    public void beforeTest() {
        super.beforeTest();

        mainPage = new MainPage(driver);
        geoPage = new GeoPage(driver);
        mainPage.open();
    }

    @Test()
    public void dependencyOfMoreButtonTest() {
        mainPage.clickOnGeoLink();

        geoPage.setCityInput("Харьков");
        geoPage.clickOnVariantOfCity(1);
        geoPage.clickOnSaveButton();

        mainPage.clickOnShowMoreHomeLink();
        ArrayList<String> kharkovShowMore = mainPage.getMoreLinksFragment().getHeaderOfLinks();

        mainPage.clickOnGeoLink();

        geoPage.setCityInput("Киев");
        geoPage.clickOnVariantOfCity(1);
        geoPage.clickOnSaveButton();

        mainPage.clickOnShowMoreHomeLink();
        ArrayList<String> kievShowMore = mainPage.getMoreLinksFragment().getHeaderOfLinks();

        if (kharkovShowMore.size() == kievShowMore.size()) {
            for (int i = 0; i < kharkovShowMore.size(); i++) {
                softAssert.assertEquals(kharkovShowMore.get(i).toLowerCase(),
                        kievShowMore.get(i).toLowerCase(),
                        "Kharkov: " + kharkovShowMore.get(i) +
                                ", Kiev: " + kievShowMore.get(i));
            }
        } else {
            System.err.println("Kharkov:");
            for (String header : kharkovShowMore) {
                System.err.print(header + " ");
            }
            System.out.println();

            System.err.println("Kiev:");
            for (String header : kievShowMore) {
                System.err.print(header + " ");
            }
        }

        softAssert.assertAll();
    }
}
