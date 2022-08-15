package jensenspb.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPageScooter {

    private WebDriver driver;


    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    private By acceptCookiesButton = By.xpath(".//button[text()='да все привыкли']");
    private By name = By.xpath(".//input[@placeholder='* Имя']");
    private By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By subwaySearchField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By subwayDropDown = By.className("select-search__select");
    private By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentPeriod = By.className("Dropdown-placeholder");
    private By rentPeriodOneDay = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    private By rentPeriodThreeDays = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]");
    private By blackColor = By.id("black");
    private By greyColor = By.id("grey");
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Buttons__1xGrp > button:nth-child(2)");
    private By acceptanceOrderButton = By.xpath(".//button[text()='Да']");
    private By successOrderMessage = By.cssSelector(".Order_ModalHeader__3FDaJ");

    public void clickAcceptCookieButton() {
        driver.findElement(acceptCookiesButton).click();
    }

    public void setName(String userName) {
        driver.findElement(name).sendKeys(userName);
    }

    public void setSurname(String userSurname) {
        driver.findElement(surname).sendKeys(userSurname);
    }

    public void setAddress(String userAddress) {
        driver.findElement(address).sendKeys(userAddress);
    }

    public void setSubwayStation(String userSubway) {
        driver.findElement(subwaySearchField).sendKeys(userSubway);
        driver.findElement(subwayDropDown).click();
    }

    public void setPhoneNumber(String userPhoneNumber) {
        driver.findElement(phoneNumber).sendKeys(userPhoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void setDate(String deliveryDate) {
        driver.findElement(dateField).sendKeys(deliveryDate);
        driver.findElement(dateField).sendKeys(Keys.RETURN);
    }

    public void setRentPeriod(int days) {
        driver.findElement(rentPeriod).click();
        if (days == 1) {
            driver.findElement(rentPeriodOneDay).click();
        } else if (days == 3) {
            driver.findElement(rentPeriodThreeDays).click();
        }
    }

    public void setColor(String color) {
        if (color.equals("black")) {
            driver.findElement(blackColor).click();
        } else if (color.equals("grey")) {
            driver.findElement(greyColor).click();
        }
    }

    public void setComment(String userComment) {
        driver.findElement(comment).sendKeys(userComment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickAcceptOrderButton() {
        driver.findElement(acceptanceOrderButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successOrderMessage).getText();
    }

    public void fillCustomerPage(String customerName, String customerSurname, String customerAddress,
                                 String customerSubwayStation, String customerPhoneNumber) {
        setName(customerName);
        setSurname(customerSurname);
        setAddress(customerAddress);
        setSubwayStation(customerSubwayStation);
        setPhoneNumber(customerPhoneNumber);
        clickNextButton();
    }

    public void fillDeliveryPage(String deliveryDate, int rentDays, String scooterColor, String customerComment) {
        setDate(deliveryDate);
        setRentPeriod(rentDays);
        setColor(scooterColor);
        setComment(customerComment);
        clickOrderButton();
        clickAcceptOrderButton();
    }

}
