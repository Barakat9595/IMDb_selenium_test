package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By signInButton = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[5]/a");
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }
    public LoginPage clickSignIn()
    {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }



};
