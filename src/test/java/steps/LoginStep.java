package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginStep extends BaseStep{

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void succesStep() {
        getDriver().get("https://demoqa.com/login");
        loginPage.getUserName().sendKeys("Liza802");
        loginPage.getPassword().sendKeys("Kk8027541335@");
        jsClick(loginPage.getLogin());
    }

    public void incorrectStep() throws InterruptedException{
        getDriver().get("https://demoqa.com/login");
        loginPage.getUserName().sendKeys("sdfgh");
        loginPage.getPassword().sendKeys("dcfvgtyhu");
        jsClick(loginPage.getLogin());
        Actions actions1 = new Actions(driver);
        Thread.sleep(2000);
        actions1.moveToElement(loginPage.getErrorMessage());
    }
    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);}

}
