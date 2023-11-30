package LoginTest;

import BaseTests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import sitePages.*;


public class LoginTest extends BaseTest {

    //test scenario 1 - valid e2e login with complete rate and add to watchlist scenario
    @Test
    public void testSuccessLogin() throws InterruptedException {
        LoginPage loginPage = homePage.clickSignIn();
        EnterCredentialsPage enterCredentialsPage = loginPage.clickSignIn();
        enterCredentialsPage.enterEmail("itiuser64@gmail.com");
        enterCredentialsPage.enterPasswd("Itiuser64@itit");
        UserHomePage userHomePage = enterCredentialsPage.clickSignIn(); //this is where the program switch pages -> functionality of element that transfer me to another page (userhomepage)
        userHomePage.enterMovieName("the dark knight");
        SearchResultPage searchResultPage = userHomePage.clickSearch();
        MoviePage moviePage = searchResultPage.choosingMovie();
        /* String checkMovieName = moviePage.getMovieName();
        Assert.assertEquals(checkMovieName,"The Dark Knight"); */
        Thread.sleep(20000);
        moviePage.rateMovie();
        moviePage.chooseRate();
        moviePage.submitRate();
        moviePage.addToWatchList();
        /* String listMsg = moviePage.watchListMsg();
        Assert.assertEquals(listMsg,"In Watchlist"); */
        WatchListPage watchListPage = moviePage.viewWatchList();
        String movieAdded = watchListPage.getMovieName();
        Assert.assertEquals(movieAdded,"The Dark Knight");
        MoviePage moviePage1 = watchListPage.backToMoviePage();
        moviePage1.addToWatchList();
        //checking if it's deleted
        Thread.sleep(5000);
        WatchListPage watchListPage1 = moviePage1.viewWatchList();
        String checkEmpty = watchListPage1.checkListIsEmpty();
        Assert.assertEquals(checkEmpty,"Your Watchlist is empty");


    }

    @Test
    public void invalidLoginWithWrongPasswd() throws InterruptedException { //sleep
        LoginPage loginPage = homePage.clickSignIn();
        EnterCredentialsPage enterCredentialsPage = loginPage.clickSignIn();
        enterCredentialsPage.enterEmail("itiuser64@gmail.com");
        enterCredentialsPage.enterPasswd("Itiuser64@itit2131");
        enterCredentialsPage.clickSignIn();
        Thread.sleep(5000);
        String wrongPasswd =  enterCredentialsPage.getWrongPasswdAlert();
        Assert.assertNotEquals(wrongPasswd,"There was a problem");
    }


    @Test
    public void ivalidLoginWithNoCredentials()
    {
        LoginPage loginPage = homePage.clickSignIn();
        EnterCredentialsPage enterCredentialsPage = loginPage.clickSignIn();
        enterCredentialsPage.clickSignIn();
        String noMail = enterCredentialsPage.getEmailAlert();
        Assert.assertEquals(noMail,"Enter your email or mobile phone number");
    }





}
