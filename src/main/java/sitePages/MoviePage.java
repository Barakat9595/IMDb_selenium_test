package sitePages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoviePage {
    private WebDriver driver;
    public MoviePage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By ratingStar = By.xpath("//div[@class='sc-e226b0e3-3 dwkouE']//div[@class='sc-3a4309f8-0 bjXIAP sc-9aa2061f-1 foKegm']//div[@class='sc-3a4309f8-1 dggvUg']//button");
    private By chooseLvl = By.xpath("//button[@aria-label='Rate 10']");
    private By submitRateBtn = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div[2]/button");
    private By wathchlistBtn = By.className("ipc-split-button__btn");
    private By watchListAdded = By.xpath("//*[@id=\"__next\"]/main/div/section[1]/section/div[3]/section/section/div[3]/div[2]/div[2]/div[3]/div/div/button[1]/div/div[1]");
    private By watchListMenu = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[4]/a/span");
    private By movieName = By.className("sc-7f1a92f5-1 benbRT");

    public String watchListMsg()
    {
        return driver.findElement(watchListAdded).getText();
    }

    public void rateMovie()
    {

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     //  WebElement ratingStarElement = wait.until(ExpectedConditions.elementToBeClickable(ratingStar));

        driver.findElement(ratingStar).click();
    }
    public void chooseRate()
    {

        WebElement chooseLevelElement = driver.findElement(chooseLvl);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chooseLevelElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chooseLevelElement);

    }
    public void submitRate()
    {
        driver.findElement(submitRateBtn).click();
    }
    public void addToWatchList()
    {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement watchListButton = wait.until(ExpectedConditions.elementToBeClickable(wathchlistBtn));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", watchListButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", watchListButton);


    }

    public WatchListPage viewWatchList()
    {
        int maxAttempts = 3;
        int attempt = 0;

        while (attempt < maxAttempts) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement watchListMenuElement = wait.until(ExpectedConditions.elementToBeClickable(watchListMenu));

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", watchListMenuElement);
                watchListMenuElement.click();

                return new WatchListPage(driver);
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                // Element reference became stale or click intercepted, retry after a small delay
                attempt++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        throw new RuntimeException("Failed to click watch list menu after multiple attempts.");
    }

    public String getMovieName()
    {
        return driver.findElement(movieName).getText();
    }










}
