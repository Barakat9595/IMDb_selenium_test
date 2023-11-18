package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditPage {
    private WebDriver driver;
    public EditPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By checkBox = By.xpath("//*[@id=\"main\"]/div[2]/div[3]/div[5]/div/div[1]/div/label");
    private By deleteBtn = By.id("delete_items");
    private By doneBtn = By.xpath("//*[@id=\"main\"]/div[1]/button");
    private By afterDelete = By.className("lister-new-instructions");


    public void checkMovie()
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the checkbox to be clickable
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkBox));

        // Scroll the checkbox into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);

        // Check or uncheck the checkbox using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

        // Wait for the checkbox to become invisible or hidden
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
    }



    public void deleteMovie()
    {
        driver.findElement(deleteBtn).click();
    }

    public WatchListPage backToList()
    {
        driver.findElement(doneBtn).click();
        return new WatchListPage(driver);
    }
    public String movieDeletedOrnot()
    {
        return driver.findElement(afterDelete).getText();
    }








}

