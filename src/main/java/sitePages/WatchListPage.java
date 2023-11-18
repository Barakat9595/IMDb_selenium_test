package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WatchListPage {
    private WebDriver driver;
    public WatchListPage(WebDriver driver)
    {
        this.driver = driver;
    }
    private By emptyWatchListTxt = By.className("empty-watchlist-text");
    private By movieName = By.xpath("//*[@id=\"page-1\"]/div/div/div[2]/h3/a");
    private By editBtn = By.xpath("//a[@refmarker='wl_edt_pwr']");
    private By backToHomeBtn = By.id("home_img_holder");

    public String getMovieName()
    {
        return driver.findElement(movieName).getText();
    }

    public String checkListIsEmpty()
    {
        return driver.findElement(emptyWatchListTxt).getText();
    }

    public EditPage editMyList()
    {
        driver.findElement(editBtn).click();
        return new EditPage(driver);
    }

    public UserHomePage backToHome()
    {
        driver.findElement(backToHomeBtn).click();
        return new UserHomePage(driver);
    }

    public MoviePage backToMoviePage()
    {
        driver.findElement(movieName).click();
        return new MoviePage(driver);
    }




}
