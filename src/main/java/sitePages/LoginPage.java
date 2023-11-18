package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //locating login element
    private By SignIn = By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]");



    public EnterCredentialsPage clickSignIn()
    {
        driver.findElement(SignIn).click();
        return new EnterCredentialsPage(driver);
    }





}
