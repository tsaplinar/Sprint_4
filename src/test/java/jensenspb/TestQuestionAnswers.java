package jensenspb;

import jensenspb.pageobjects.HomePageScooter;
import jensenspb.pageobjects.components.Question;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Parameterized.class)
public class TestQuestionAnswers {

    private WebDriver driver;
    private Question question;

    public TestQuestionAnswers(Question question) {
        this.question = question;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        options.addArguments("--start-maximized");
        options.addArguments("--window-size=1920x1080");
        driver = new ChromeDriver(options);
    }

    @Parameterized.Parameters
    public static Question[] getQuestions() {
        return HomePageScooter.getHomePageQuestions();
    }

    @Test
    public void CheckQuestion() {
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePageScooter.waitForAnswersComponent();
        homePageScooter.acceptCookies();
        Assert.assertEquals(question.getQuestion(), homePageScooter.getQuestionText(question));
        Assert.assertEquals(question.getAnswer(), homePageScooter.getAnswerText(question));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
