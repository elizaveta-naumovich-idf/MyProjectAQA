package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.MainPage;
import pages.base_abstract.LoginPage;
import steps.LoginStep;
import utils.TestUtils;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {

    private final static String BASE_URL = "https://demoqa.com/books";
    private WebDriver driver;

    protected LoginPage loginPage;

    protected LoginStep loginStep;

    @BeforeMethod
    protected void beforeMethod(Method method, ITestResult result) {
        driver = BaseUtils.createDriver();
        loginPage = new LoginPage(driver);
        loginStep = new LoginStep(driver);
    }

    @AfterMethod
    protected void afterMethod(Method method, ITestResult result) {
        driver.quit();
    }

    protected WebDriver getDriver() {

        return driver;
    }

    public static String getBaseUrl() {

        return BASE_URL;
    }


    public MainPage openBaseURL() {
        TestUtils.loadBaseUrlPage(getDriver());

        return new MainPage(getDriver());
    }

}
