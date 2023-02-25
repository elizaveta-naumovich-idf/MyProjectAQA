package pages.base_abstract;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
    public WebDriver driver;


    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected List<String> getTexts(List<WebElement> list) {
        if (list.size() > 0) {
            List<String> textList = new ArrayList<>();
            for (WebElement element : list) {
                    textList.add(element.getText());
            }

            return textList;
        }

        return new ArrayList<>();
    }

}
