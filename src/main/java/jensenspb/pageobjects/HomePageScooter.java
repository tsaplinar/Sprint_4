package jensenspb.pageobjects;

import jensenspb.pageobjects.components.Question;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageScooter {
    private WebDriver driver;

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Принять куки
    private By acceptCookiesButton = By.xpath("//*[@id=\"rcc-confirm-button\"]");

    //Заголовок qua
    private By questionsAreaHeader = By.cssSelector("#root > div > div > div.Home_FourPart__1uthg");

    //Верхняя кнопка зазать
    private By headerOrderButton = By.cssSelector("[class='Header_Nav__AGCXC']>[class='Button_Button__ra12g']");

    //Кнопка заказать на домашней странице внизу
    private By homeOrderButton = By.cssSelector("div.Home_FinishButton__1_cWm > button");

    //Кнопки вопроса и ответа
    private static final Question[] questions = new Question[]{
            new Question(
                    By.xpath("//*[@id=\"accordion__heading-0\"]"),
                    By.xpath("//*[@id=\"accordion__panel-0\"]//p"),
                    "Сколько это стоит? И как оплатить?",
                    "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
            ),
            new Question(
                    By.xpath("//*[@id=\"accordion__heading-1\"]"),
                    By.xpath("//*[@id=\"accordion__panel-1\"]//p"),
                    "Хочу сразу несколько самокатов! Так можно?",
                    "Пока что у нас так: один заказ — один самокат." +
                            " Если хотите покататься с друзьями," +
                            " можете просто сделать несколько заказов — один за другим."
            ),
            new Question(
                    By.xpath("//*[@id=\"accordion__heading-2\"]"),
                    By.xpath("//*[@id=\"accordion__panel-2\"]//p"),
                    "Как рассчитывается время аренды?",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                            "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
                            " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."
            ),
            new Question(
                    By.xpath("//*[@id=\"accordion__heading-3\"]"),
                    By.xpath("//*[@id=\"accordion__panel-3\"]//p"),
                    "Можно ли заказать самокат прямо на сегодня?",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее."
            ),
            new Question(
                    By.xpath("//*[@id=\"accordion__heading-4\"]"),
                    By.xpath("//*[@id=\"accordion__panel-4\"]//p"),
                    "Можно ли продлить заказ или вернуть самокат раньше?",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому " +
                            "номеру 1010."
            ),
            new Question(
                    By.xpath("//*[@id=\"accordion__heading-5\"]"),
                    By.xpath("//*[@id=\"accordion__panel-5\"]//p"),
                    "Вы привозите зарядку вместе с самокатом?",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если " +
                            "будете кататься без передышек и во сне. Зарядка не понадобится."
            ),
            new Question(
                    By.xpath("//*[@id=\"accordion__heading-6\"]"),
                    By.xpath("//*[@id=\"accordion__panel-6\"]//p"),
                    "Можно ли отменить заказ?",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. " +
                            "Все же свои."
            ),
            new Question(
                    By.xpath("//*[@id=\"accordion__heading-7\"]"),
                    By.xpath("//*[@id=\"accordion__panel-7\"]//p"),
                    "Я жизу за МКАДом, привезёте?",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области."
            ),
    };

    public void acceptCookies() {
        driver.findElement(acceptCookiesButton).click();
    }

    public void waitForAnswersComponent() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(questionsAreaHeader));
    }

    public String clickHeaderOrderButtonGetUrl() {
        driver.findElement(headerOrderButton).click();
        return driver.getCurrentUrl();
    }

    public String clickHomeOrderButtonGetUrl() {
        driver.findElement(homeOrderButton).click();
        return driver.getCurrentUrl();
    }

    public static Question[] getHomePageQuestions() {
        return HomePageScooter.questions;
    }

    public String getQuestionText(Question question) {
        return driver.findElement(question.getQuestionSelector()).getText();
    }

    public String getAnswerText(Question question) {
        driver.findElement(question.getQuestionSelector()).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(question.getAnswerSelector()));
        return driver.findElement(question.getAnswerSelector()).getText();
    }

}
