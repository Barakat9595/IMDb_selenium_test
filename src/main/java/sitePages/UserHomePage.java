package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHomePage {

    private WebDriver driver;
    public UserHomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By search = By.id("suggestion-search");
    private By searchButton = By.id("suggestion-search-button");

    public void enterMovieName(String movie)
    {
        driver.findElement(search).sendKeys(movie);
    }

    public SearchResultPage clickSearch()
    {
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }



}
