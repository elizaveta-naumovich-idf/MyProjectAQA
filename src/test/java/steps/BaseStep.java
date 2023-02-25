package steps;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.LoginPage;

public class BaseStep {

    protected WebDriver driver;
    protected LoginPage loginPage;



    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
    }
}
