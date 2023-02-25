package utils;

import base.BaseTest;
import org.openqa.selenium.WebDriver;

public class TestUtils {


    public static void loadBaseUrlPage(WebDriver driver) {
        driver.get(BaseTest.getBaseUrl());
    }


}
