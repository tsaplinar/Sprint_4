package jensenspb;

import jensenspb.pageobjects.HomePageScooter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestOrderButtonsUrl {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testHeaderOrderButton() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        String expectedPage = "https://qa-scooter.praktikum-services.ru/order";
        homePageScooter.acceptCookies();
        Assert.assertEquals(expectedPage, homePageScooter.clickHeaderOrderButtonGetUrl());
    }

    @Test
    public void testHomeOrderButton() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        String expectedPage = "https://qa-scooter.praktikum-services.ru/order";
        homePageScooter.acceptCookies();
        Assert.assertEquals(expectedPage, homePageScooter.clickHomeOrderButtonGetUrl());
    }

    @After
    public void teardown() {
        driver.quit();
    }



}
