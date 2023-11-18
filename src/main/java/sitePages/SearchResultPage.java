package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    private WebDriver driver;
    public SearchResultPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By urmovie = By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/div/div[1]/section[2]/div[2]/ul/li[1]");
    public MoviePage choosingMovie()
    {
        driver.findElement(urmovie).click();
        return new MoviePage(driver);
    }







}
