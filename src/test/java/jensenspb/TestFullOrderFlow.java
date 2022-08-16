package jensenspb;

import jensenspb.pageobjects.OrderPageScooter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestFullOrderFlow {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testOrderFirstSetOfData() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        orderPageScooter.clickAcceptCookieButton();
        orderPageScooter.fillCustomerPage("Вася", "Пупкин", "Октябрьская набережная 1", "Сокольники", "+79998887766");
        orderPageScooter.fillDeliveryPage("14.10.2022", 1, "black", "На углу дома");
        String successMessage = orderPageScooter.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("Заказ оформлен"));
    }

    @Test
    public void testOrderSecondSetOfData() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        orderPageScooter.clickAcceptCookieButton();
        orderPageScooter.fillCustomerPage("Пётр", "Петров", "Крыленко 1", "Лубянка", "+79214447689");
        orderPageScooter.fillDeliveryPage("14.01.2023", 3, "grey", "После обеда");
        String successMessage = orderPageScooter.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("Заказ оформлен"));
    }


    @After
    public void teardown() {
        driver.quit();
    }


}
