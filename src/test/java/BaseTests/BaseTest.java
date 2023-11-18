package BaseTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import sitePages.HomePage;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeTest
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com/");
        homePage = new HomePage(driver);
    }
    @AfterTest
    public void quiting()
    {
        driver.quit();
    }
}
