package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterCredentialsPage {
    private WebDriver driver;
    public EnterCredentialsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By email = By.id("ap_email");
    private By passwd = By.id("ap_password");
    private By signIn = By.className("a-button-input");
    private By emailAlert = By.xpath("//*[@id=\"auth-email-missing-alert\"]/div/div");
    private By passwordAlert = By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div");
    private By wrongPasswdAlert = By.xpath("//*[@id=\"auth-error-message-box\"]/div/h4");


    //creating interaction methods for this class (page)

    public void enterEmail(String usermail)
    {
        driver.findElement(email).sendKeys(usermail);
    }

    public void enterPasswd(String password)
    {
        driver.findElement(passwd).sendKeys(password);
    }

    public UserHomePage clickSignIn()
    {
        driver.findElement(signIn).click();
        return new UserHomePage(driver);
    }

    public String getEmailAlert()
    {
        return driver.findElement(emailAlert).getText();
    }
    public String getPasswdAlert()
    {
        return driver.findElement(passwordAlert).getText();
    }
    public String getWrongPasswdAlert()
    {
        return driver.findElement(wrongPasswdAlert).getText();
    }



}
