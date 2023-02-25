package tests;
import base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Log
public class MainTest extends BaseTest {

    @Test(
            testName = "проверка названия книг на UI и API")
    public void test09() {
        final List<String> expButtonTexts = List.of(
                "Git Pocket Guide",
                "Learning JavaScript Design Patterns",
                "Designing Evolvable Web APIs with ASP.NET",
                "Speaking JavaScript",
                "You Don't Know JS",
                "Programming JavaScript Applications",
                "Eloquent JavaScript, Second Edition",
                "Understanding ECMAScript 6"
        );


        getDriver().get("https://demoqa.com/books");

                List<String> actButtonTexts = openBaseURL()
                        .getBooksName();



        //debug
        Reporter.log(actButtonTexts.toString(), true);

        assertEquals(actButtonTexts, expButtonTexts);



        String baseURI = "https://demoqa.com/";

        Response response = given()
                .baseUri(baseURI)
                .contentType(ContentType.JSON)
                .when().get("BookStore/v1/Books")
                .then()
                .log().all()  //debug
                .statusCode(200)
                .body("books.title", notNullValue())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<String> books = jsonPath.get("books.title");


        for (int i = 0; i < books.size(); i++) {
            //log.severe(String.);
            Assert.assertTrue(books.get(i).contains(expButtonTexts.get(i)));
        }
    }

    @Test
    public void successLogin() {
        loginStep.succesStep();
        log.severe(String.valueOf(loginStep.toString()));
        Assert.assertTrue(loginPage.getResult().isDisplayed());
    }

    @Test
    public void incorrectLogin() throws InterruptedException{
        loginStep.incorrectStep();
        log.warning(String.valueOf(loginStep.toString()));
        log.severe(String.valueOf(loginStep.toString()));
        Assert.assertEquals(loginPage.getErrorMessage().getText(), "Invalid username or password!");
    }




}
