package pages.base_abstract;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By userNameInput = By.xpath("//*[@id = 'userName']");
    private By passwordInput = By.xpath("//*[@id = 'password']");

    private By loginButton = By.xpath("//*[@id = 'login']");

    private By errorMessage = By.xpath("//*[@id = 'name']");

    private By result = By.id("app");

    public WebElement getUserName(){
        return driver.findElement(userNameInput);
    }

    public WebElement getPassword(){
        return driver.findElement(passwordInput);
    }

    public WebElement getLogin(){
        return driver.findElement(loginButton);
    }

    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }

    public WebElement getResult(){
        return driver.findElement(result);
    }
}
