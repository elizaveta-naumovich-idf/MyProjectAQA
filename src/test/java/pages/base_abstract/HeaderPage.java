package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

import java.util.List;

public abstract class HeaderPage extends BasePage {

    @FindBy(xpath = "//span[@class='mr-2']/a")
    private List<WebElement> searchBooksName;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getBooksName() {

        return getTexts(searchBooksName);
    }

}
